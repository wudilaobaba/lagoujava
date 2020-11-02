package test;

import com.lagou.edu.SpringConfig;
import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.dao.impl.JdbcAccountDaoImpl;
import com.lagou.edu.utils.ConnectionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
                                                                //配置类如果有多个的话，就以逗号的形式分来来传参
        ConnectionUtils connectionUtils1 = (ConnectionUtils) applicationContext.getBean("connectionUtils");
    }
}
