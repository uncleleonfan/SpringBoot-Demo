package com.springboot.demo.aspect;

import com.springboot.demo.pojo.User;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新接口");
        return user != null;
    }
}
