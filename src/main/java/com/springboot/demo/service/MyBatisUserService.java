package com.springboot.demo.service;

import com.springboot.demo.pojo.User;
import org.springframework.stereotype.Service;


public interface MyBatisUserService {
    public User getUser(int id);
    public int insertUser(User user);
}
