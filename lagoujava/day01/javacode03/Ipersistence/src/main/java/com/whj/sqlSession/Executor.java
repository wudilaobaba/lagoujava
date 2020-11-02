package com.whj.sqlSession;

import com.whj.pojo.Configuration;
import com.whj.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    public<E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object... params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, Exception;
    void dml(Configuration configuration, MappedStatement mappedStatement,Object... params) throws Exception;
}
