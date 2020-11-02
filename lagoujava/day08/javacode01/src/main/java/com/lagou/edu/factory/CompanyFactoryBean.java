package com.lagou.edu.factory;

import com.lagou.edu.pojo.Company;
import org.springframework.beans.factory.FactoryBean;

public class CompanyFactoryBean implements FactoryBean<Company> {
    private String companyInfo;//名称,地址,规模

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Override
    /**
     * 返回FactoryBean创建的Bean实例，如果下面的isSingleton返回true，
     * 则该实例会放到Spring容器 的单例对象缓存池中Map
     */

    public Company getObject() throws Exception {//
        //创建复杂对象Company
        Company company = new Company();
        String[] strings = companyInfo.split(",");
        company.setName(strings[0]);
        company.setAddress(strings[1]);
        company.setScale(Integer.parseInt(strings[2]));
        return company;
    }

    @Override
    public Class<?> getObjectType() {// 返回FactoryBean创建的Bean类型s
        return Company.class;
    }

    @Override
    public boolean isSingleton() {// 返回作⽤域是否单例
        return true;
    }
}
