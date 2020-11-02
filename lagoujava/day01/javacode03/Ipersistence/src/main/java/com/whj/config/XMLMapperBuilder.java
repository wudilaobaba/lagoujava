package com.whj.config;

import com.whj.SqlType;
import com.whj.pojo.Configuration;
import com.whj.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.*;

/**
 * sql配置文件解析
 */
public class XMLMapperBuilder {
    private Configuration configuration;
    public XMLMapperBuilder(Configuration configuration){
        this.configuration = configuration;
    }
    public void parse(InputStream in) throws DocumentException {
        Document document = new SAXReader().read(in);

        Element rootElement = document.getRootElement();//<mapper>
        String nameSpace = rootElement.attributeValue("nameSpace");
        //mapper文件中可用存放sql的标签
        String[] tags = {"select","update","delete","insert"};
        List<String> tagNames = Arrays.asList(tags);

        for (String tagName : tagNames) {
            List<Element> selects = rootElement.selectNodes("//"+tagName);
            for (Element select : selects) {
                String id = select.attributeValue("id");
                String resultType = select.attributeValue("resultType");
                String paramterType = select.attributeValue("paramterType");
                String sql = select.getTextTrim();

                MappedStatement mappedStatement = new MappedStatement();
                mappedStatement.setId(id);
                mappedStatement.setResultType(resultType);
                mappedStatement.setParamterType(paramterType);
                mappedStatement.setSql(sql);
                switch (tagName){
                    case "select":
                        mappedStatement.setSqlType(SqlType.SELECT);
                        break;
                    case "update":
                        mappedStatement.setSqlType(SqlType.UPDATE);
                        break;
                    case "delete":
                        mappedStatement.setSqlType(SqlType.DELETE);
                        break;
                    case "insert":
                        mappedStatement.setSqlType(SqlType.INSERT);
                        break;
                }


                this.configuration.getMappedStatementMap().put(nameSpace+"."+id,mappedStatement);
            }
        }

    }

    /**
     * 解析全部标签
     */
    private void parseTags(List<String> tagNames,String nameSpace){


    }
}
