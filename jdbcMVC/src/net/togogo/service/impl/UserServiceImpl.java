package net.togogo.service.impl;

import net.togogo.bean.User;
import net.togogo.dao.UserDao;
import net.togogo.dao.impl.UserDaoImpl;
import net.togogo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> selectUserAll() {
        return userDao.selectUserAll();
    }

    @Override
    public int deleteUserById(String id) {
        return userDao.deleteUserById(id);
    }
}
