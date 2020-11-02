package test;

import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.dao.impl.JdbcAccountDaoImpl;
import com.lagou.edu.utils.ConnectionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    @Test
    public void test01(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConnectionUtils connectionUtils1 = (ConnectionUtils) applicationContext.getBean("connectionUtils");
        ConnectionUtils connectionUtils2 = (ConnectionUtils) applicationContext.getBean("connectionUtils");
        System.out.println(connectionUtils1);
        System.out.println(connectionUtils2);
        /**
         * scope="singleton":单例 容器中只有一个对象，每次getBean都是同一个对象 (默认值)
         * scope="property": 多例 每次getBean,都会返回一个新的对象
         */
        JdbcAccountDaoImpl accountDao1 = (JdbcAccountDaoImpl) applicationContext.getBean("accountDao");
        JdbcAccountDaoImpl accountDao2 = (JdbcAccountDaoImpl) applicationContext.getBean("accountDao");
        System.out.println(accountDao1.getName());
        System.out.println(accountDao1.getAge());
        System.out.println(accountDao1.getMyArray());
        System.out.println(accountDao1.getMySet());
        System.out.println(accountDao1.getMyMap());
        System.out.println(accountDao1.getMyProperties());
        System.out.println(accountDao1 == accountDao2);
        applicationContext.close();//bean为单例才会执行bean的销毁方法
    }
}
