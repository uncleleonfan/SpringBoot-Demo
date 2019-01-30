package com.springboot.demo.service;

import com.springboot.demo.dao.MyBatisUserDao;
import com.springboot.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    public User getUser(int id) {
        return myBatisUserDao.getUser(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    @Override
    public int insertUser(User user) {
        return myBatisUserDao.insertUser(user);
    }
}
