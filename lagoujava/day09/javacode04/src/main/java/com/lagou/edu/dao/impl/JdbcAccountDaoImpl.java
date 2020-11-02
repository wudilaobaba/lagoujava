package com.lagou.edu.dao.impl;

import com.lagou.edu.pojo.Account;
import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.utils.ConnectionUtils;
import com.lagou.edu.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 应癫
 */
public class JdbcAccountDaoImpl implements AccountDao {
    private String name;
    private Integer age;
    private ConnectionUtils connectionUtils;
    private String[] myArray;
    private Map<String,String> myMap;
    private Set<String> mySet;
    private Properties myProperties;

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyProperties(Properties myProperties) {
        this.myProperties = myProperties;
    }

    public String[] getMyArray() {
        return myArray;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public Set<String> getMySet() {
        return mySet;
    }

    public Properties getMyProperties() {
        return myProperties;
    }

    public JdbcAccountDaoImpl(ConnectionUtils connectionUtils, String names, Integer ages){
        this.connectionUtils = connectionUtils;
        this.name = names;
        this.age = ages;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }



    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }


    public void init() {
        System.out.println("初始化方法.....");
    }

    public void destory() {
        System.out.println("销毁方法......");
    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        //从连接池获取连接
        // Connection con = DruidUtils.getInstance().getConnection();
        Connection con = connectionUtils.getCurrentThreadConn();
        String sql = "select * from account where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while(resultSet.next()) {
            account.setCardNo(resultSet.getString("cardNo"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getInt("money"));
        }

        resultSet.close();
        preparedStatement.close();
        //con.close();

        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {

        // 从连接池获取连接
        // 改造为：从当前线程当中获取绑定的connection连接
        //Connection con = DruidUtils.getInstance().getConnection();
        Connection con = connectionUtils.getCurrentThreadConn();
        String sql = "update account set money=? where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,account.getMoney());
        preparedStatement.setString(2,account.getCardNo());
        int i = preparedStatement.executeUpdate();

        preparedStatement.close();
        //con.close();
        return i;
    }
}
