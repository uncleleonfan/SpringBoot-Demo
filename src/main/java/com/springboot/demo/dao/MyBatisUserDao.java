package com.springboot.demo.dao;

import com.springboot.demo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
    User getUser(int id);
    int insertUser(User user);
}
