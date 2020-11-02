package com.whj.sqlSession;

import java.sql.SQLException;
import java.util.List;

public interface SqlSession {
    //为dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);

    //查询所有
    public<E> List<E> selectList(String statementId,Object... params) throws Exception;//可变参数

    //根据条件查询单个
    public<T> T selectOne(String statementId,Object... params) throws Exception;

    //修改
    public void dmlControl(String statementId,Object... params) throws Exception;


}
