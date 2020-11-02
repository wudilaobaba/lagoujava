package com.whj.config;

import com.whj.pojo.Configuration;
import com.whj.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Element> selects = rootElement.selectNodes("//select");

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

            this.configuration.getMappedStatementMap().put(nameSpace+"."+id,mappedStatement);
        }
    }
}
