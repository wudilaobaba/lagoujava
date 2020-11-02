package com.whj.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whj.io.Resources;
import com.whj.pojo.Configuration;
import com.whj.pojo.MappedStatement;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Getter
@Setter
/**
 * 数据库配置信息解析
 */
public class XMLConfigBuilder {
    private Configuration configuration;
    private MappedStatement mappedStatement;
    public XMLConfigBuilder(){
        this.configuration = new Configuration();
        this.mappedStatement = new MappedStatement();
    }
    /**
     * 该方法就是使用dom4j将配置文件进行解析，封装Configuration
     * @return Configuration onfiguration 所有xml配置文件的信息：( DataSource以及全部的sql信息 )
     */
    public Configuration parseConfig(InputStream in) throws Exception {
        //解析 sqlMapperConfig.xml
        Document document = new SAXReader().read(in);
        Element rootElement = document.getRootElement();//<configuration>
        List<Element> list = rootElement.selectNodes("//property");//所有<property>
        Properties properties = new Properties();
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);
        }
        //设置数据库连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass((String)properties.get("driverClass"));
        comboPooledDataSource.setJdbcUrl((String)properties.get("jdbcUrl"));
        comboPooledDataSource.setUser((String)properties.get("userName"));
        comboPooledDataSource.setPassword((String)properties.get("password"));

        this.configuration.setDataSource(comboPooledDataSource);


        //解析 xxxMapper.xml
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for (Element element : mapperList) {
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(this.configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return this.configuration;
    }
}
