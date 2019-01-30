package com.springboot.demo;

import com.springboot.demo.aspect.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

//Spring Boot入门文件
@SpringBootApplication
@EntityScan(basePackages = "com.springboot.demo.pojo")
@MapperScan(basePackages = "com.springboot.demo.*", annotationClass = Repository.class)
public class SpringBootDemoApplication {


    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

