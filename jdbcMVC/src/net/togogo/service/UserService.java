package net.togogo.service;

import net.togogo.bean.User;

import java.util.List;

public interface UserService {
    List<User> selectUserAll();

    int deleteUserById(String id);
}
