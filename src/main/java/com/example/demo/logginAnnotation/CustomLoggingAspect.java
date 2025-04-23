package com.example.demo.logginAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CustomLoggingAspect {

    @Around("@annotation(com.example.demo.logginAnnotation.CustomLogging)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println(" - Parameters: " + Arrays.toString(joinPoint.getArgs()));

        Object proceed = joinPoint.proceed();

        long executionATime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + ":" + "Execution Time" + " = " + executionATime);

        return proceed;
    }
}
