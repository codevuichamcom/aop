package com.funny.code.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ValidatePositiveAspect {

    @Pointcut("@annotation(com.funny.code.annotation.PositiveNumber)")
    public void positiveNumberCheck() {
    }

    @Before("positiveNumberCheck() && args(..)")
    public void validatePositiveNumber(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("here");
        for (Object arg : args) {
            if (arg instanceof String) {
                try {
                    int number = Integer.parseInt((String) arg);
                    if (number <= 0) {
                        throw new IllegalArgumentException("Invalid argument: " + number + ", must be positive number.");
                    }
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Invalid argument: " + arg + ", must be a number.");
                }
            }
        }
    }
}
