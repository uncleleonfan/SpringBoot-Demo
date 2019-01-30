package com.springboot.demo.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    //增强UserServiceImpl接口
    //FIX ME:ReflectionWorldException: warning can't determine implemented interfaces of missing type org.springframework.boot.autoconfigure
//    @DeclareParents(value = "com.springboot.demo.service.UserServiceImpl+", defaultImpl = UserValidatorImpl.class)
//    public UserValidator userValidator;

    //定义切点 注意* 后面有个空格
    @Pointcut("execution(* com.springboot.demo.service.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before ...");
    }

    //获取通知参数
//    @Before("pointCut() && args(user)")
//    public void beforeParam(JoinPoint joinPoint, User user) {
//        Object[] args = joinPoint.getArgs();
//        System.out.println("before ...");
//    }

    //环绕通知
    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before ...");
        jp.proceed();
        System.out.println("around after ...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after ...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {

    }
}
