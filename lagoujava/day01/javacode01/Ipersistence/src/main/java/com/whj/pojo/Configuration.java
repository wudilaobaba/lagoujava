package com.whj.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 存放sqlMapperConfig.xml中的内容：也就是数据库相关信息
 */
@Data
/**
 * 数据库连接池以及所有sql信息
 */
public class Configuration {
    //数据库连接池
    private DataSource dataSource;

    /**
     * key: statementid
     * value: 封装好的MappedStatement 一个<select></select>对应一个MappedStatement对象
     */
    private Map<String,MappedStatement> mappedStatementMap = new HashMap<>();
}
