package com.whj.sqlSession;

import com.whj.pojo.Configuration;

import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;

public class DefaultSqlSession implements SqlSession{
    private Configuration configuration;
    public DefaultSqlSession(Configuration configuration){
        this.configuration = configuration;
    }
    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<Object> list = simpleExecutor.query(this.configuration, this.configuration.getMappedStatementMap().get(statementId), params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objects = this.selectList(statementId,params);
        if(objects.size() == 1){
            return (T) objects.get(0);
        }   else{
            throw new RuntimeException("查询结果为空 或 返回结果过多");
        }
    }

    @Override
    /**
     * 用来生产使用端dao接口的实现类(代理实现类)
     */
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理来为DAO接口生成代理对象，并返回
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            //代理对象执行接口中的任一方法，都会去执行下面的invoke方法
            /**
             * 参数说明：
             * proxy : 当前代理对象的应用
             * method : 当前被调用方法的引用，即findAll
             * args: 接口方法中的参数
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //根据不同情况来调用selectList或selectOne
                //准备selectList或selectOne的参数
                //由于这里无法获取到statementId,即sqlmapper的nameSpace.id。那么就需要将nameSpace.id的命名进行规范化
                //nameSpace - Dao接口全包路径
                //id - Dao接口的方法名(与sql语句进行对应)
                //如果sqlmapper的nameSpace.id == 接口全路径.接口中的某个方法名
                String methodName = method.getName();//接口中的某个方法名
                String className = method.getDeclaringClass().getName();//接口全路径

                String statementId = className+"."+methodName;//参数1
                                                         //args 参数2
                //根据selectList或selectOne的返回结果来选择执行两者中的哪个方法

                //获取被调用方法的返回值类型:
                Type genericReturnType = method.getGenericReturnType();
                //是否进行了泛型类型参数化，就是判断方法的返回值类型是否有泛型，有泛型就认为是一个List,否则就认为是一个实体
                if(genericReturnType instanceof ParameterizedType){
                    return selectList(statementId,args);
                }
                return selectOne(statementId,args);
            }
        });
        return (T) proxyInstance;
    }
}
