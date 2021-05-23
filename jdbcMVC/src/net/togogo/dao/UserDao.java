package net.togogo.dao;

import net.togogo.bean.User;

import java.util.List;

public interface UserDao {
    List<User> selectUserAll();

    int deleteUserById(String id);
}
