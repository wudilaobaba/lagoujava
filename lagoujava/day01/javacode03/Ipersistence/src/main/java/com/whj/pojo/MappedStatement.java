package com.whj.pojo;

import com.whj.SqlType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 存放mapper.xml解析出来的内容：也就是sql语句相关信息
 */
@Data
public class MappedStatement {
    //select标签上的id
    private String id;

    //返回值类型
    private String resultType;

    //参数值类型
    private String paramterType;

    //sql语句
    private String sql;

    //当前标签是什么
    private SqlType sqlType;

}
