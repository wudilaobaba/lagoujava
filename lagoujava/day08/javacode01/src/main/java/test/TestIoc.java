package test;

import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.dao.impl.JdbcAccountDaoImpl;
import com.lagou.edu.pojo.Result;
import com.lagou.edu.utils.ConnectionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    /**
     * 测试bean对象的延迟加载
     */
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Result lazyResult = (Result) applicationContext.getBean("lazyResult");

        Object companyBean = applicationContext.getBean("companyBean");
        System.out.println(companyBean);//神奇，竟然是Company类型！！！

        Object companyBean1 = applicationContext.getBean("&companyBean");//想获取到自己本身的FactoryBean，就加一个&字符
        System.out.println(companyBean1);

    }
}
