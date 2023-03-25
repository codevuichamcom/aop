package com.funny.code.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class PositiveNumberAspect {

    @Before("execution(* com.funny.code..*.*(.., @com.funny.code.annotation.PositiveNumber (*), ..))")
    public void handlePositiveNumberAnnotation(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (Arrays.stream(args).anyMatch(num -> (Integer) num <= 0)) {
            throw new IllegalArgumentException("Tham so phai duong");
        }
    }

    @Around("execution(* com.funny.code.controller..*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("EX: " + throwable.getMessage());
            return null;
        }
    }
}