package com.springboot.demo.service;

import com.springboot.demo.pojo.User;
import org.springframework.stereotype.Service;


//使用@Service注解，会被IoC容器扫描注入
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空");
        }
        System.out.print("id=" + user.getId());
        System.out.print("\tusername=" + user.getUserName());
        System.out.print("\tnote=" + user.getNote());
    }
}
