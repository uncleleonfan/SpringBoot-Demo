package com.springboot.demo.aspect;

import com.springboot.demo.model.User;

/**
 * 假定UserService这个服务不是自己提供，而是由别人提供，不能修改，可以增强这个接口功能
 */
public interface UserValidator {
    public boolean validate(User user);
}
