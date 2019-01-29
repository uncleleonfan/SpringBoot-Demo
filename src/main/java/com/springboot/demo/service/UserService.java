package com.springboot.demo.service;

import com.springboot.demo.model.User;
import org.springframework.stereotype.Service;

//@Service 无效
public interface UserService {

    public void printUser(User user);
}
