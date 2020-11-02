package com.whj.sqlSession;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whj.config.BoundSql;
import com.whj.pojo.Configuration;
import com.whj.pojo.MappedStatement;
import com.whj.utils.GenericTokenParser;
import com.whj.utils.ParameterMapping;
import com.whj.utils.ParameterMappingTokenHandler;
import com.whj.utils.TokenHandler;
import javafx.beans.property.Property;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来执行jdbc原生代码
 */
public class SimpleExecutor implements Executor{
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {
        //select * from user where id = #{id} and username = #{username}
        String sql = mappedStatement.getSql();

        //转换sql语句：
        //select * from user where id = ? and username = ?
        BoundSql boundSql = this.getBoundSql(sql);

        //设置参数
        String paramterType = mappedStatement.getParamterType();//参数的全路径
        Class<?> paramterClass =  this.getClasType(paramterType);//参数类型
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();//参数字段名集合
        //设置数据库连接
        Connection connection = configuration.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
        //使用preparedStatement设置参数：
        for (int i = 0; i < parameterMappingList.size(); i++) {
            String content = parameterMappingList.get(i).getContent();//参数字段名
            //反射，根据content获取到实体对像的属性
            Field declaredField = paramterClass.getDeclaredField(content);//该类型获取自己的字段
            declaredField.setAccessible(true);//暴力访问
            Object o = declaredField.get(params[0]);//字段.get(宿主对象),将字段值返回
            preparedStatement.setObject(i+1,o);//参数赋值
        }


        //执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        String resultType = mappedStatement.getResultType();

        Class<?> resultTypeClass = this.getClasType(resultType);

        //封装返回结果
        ArrayList<Object> objects = new ArrayList<>();
        while(resultSet.next()) {
            Object o = resultTypeClass.newInstance();//该类的实体
            ResultSetMetaData metaData = resultSet.getMetaData();//原数据,相当于查到的一条数据
            for (int i = 1; i <=metaData.getColumnCount()/*列的个数*/ ; i++) {
                String columnName = metaData.getColumnName(i);//字段名
                Object value = resultSet.getObject(columnName);//字段值
                //使用反射或内省，根据数据库表与实体的对应关系，完成封装
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypeClass);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o,value);//给实体o赋值

            }
            objects.add(o);

        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return (List<E>) objects;
    }

    /**
     *
     * @param sql 原始sql
     * @return 真实的sql以及参数列表，封装在BoundSql中
     */
    private BoundSql getBoundSql(String sql){
        //标记处理类：解析占位符
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{","}",parameterMappingTokenHandler);
        //返回真实的jpql的sql语句
        String parseSql = genericTokenParser.parse(sql);
        //#{}中的参数名称 [{content:"username"},{content:"id"}]
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        BoundSql boundSql = new BoundSql(parseSql,parameterMappings);
        return boundSql;
    }

    private Class<?> getClasType(String paramterType) throws ClassNotFoundException {
        if(paramterType!=null){
            Class<?> aClass = Class.forName(paramterType);
            return aClass;
        }
        return null;
    }
}
