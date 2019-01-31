package com.springboot.demo.service;

import com.springboot.demo.dao.MyBatisUserDao;
import com.springboot.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    @Transactional
    //先从缓存中通过定义的键查询，如果可以查询到数据，则返回，否则执行，返回数据，将返回的数据保存到缓存中
    @Cacheable(value = "redisCache",key = "'redis_user_' +#id")
    public User getUser(int id) {
        return myBatisUserDao.getUser(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    //将方法返回的结果存放到缓存中
    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    @Override
    public int insertUser(User user) {
        return myBatisUserDao.insertUser(user);
    }
}
