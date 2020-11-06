package com.jkblog.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
@Slf4j
@Order(1)
public class UserServiceImplAdvice {

    /**
     * aop测试
     * @param proceedingJoinPoint
     * @throws Throwable
     */
    @Around(value = "execution(* com.jkblog.service.impl.UserServiceImpl.get*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      log.debug("get方法即将调用======================aop");
        Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        log.debug("get方法即将完成调用======================aop");
        return proceed;
    }

}
