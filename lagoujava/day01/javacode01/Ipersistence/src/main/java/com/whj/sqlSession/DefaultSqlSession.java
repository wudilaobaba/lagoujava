package com.whj.sqlSession;

import com.whj.pojo.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
}
