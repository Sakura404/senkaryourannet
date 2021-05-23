package net.togogo.dao.impl;

import net.togogo.bean.User;
import net.togogo.dao.UserDao;
import net.togogo.utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectUserAll() {
        String sql = "select * from user";
        Object []obj ={};
        List<User> list = new ArrayList();
        ResultSet myResultSet = JdbcUtils.getMyResultSet(sql, obj);
        try {
            while (myResultSet.next()){
             User user = new User();
             int id =    myResultSet.getInt("id");
             int age =    myResultSet.getInt("age");
             String name = myResultSet.getString("name");
             String phone = myResultSet.getString("phone");
             String address = myResultSet.getString("address");
             Date createdate = myResultSet.getTimestamp("createdate");
             Date modifydate = myResultSet.getTimestamp("modifydate");
             int createby =    myResultSet.getInt("createby");
             user.setName(name);
             user.setId(id);
             user.setAddress(address);
             user.setPhone(phone);
             user.setAge(age);
             user.setCreateby(createby);
             user.setCreatedate(createdate);
             user.setModifydate(modifydate);
             list.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteUserById(String id) {
        String sql = "delete from user where id =?";
        Object obj[] ={id};
        int count = JdbcUtils.getMyUpdate(sql, obj);

        return  count;
    }
}
