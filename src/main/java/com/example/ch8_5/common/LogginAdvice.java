package com.example.ch8_5.common;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogginAdvice {

    @Around("execution(* com.example.ch8_5.controller.*.*(..))")
    public Object methodCallLog(ProceedingJoinPoint pjp)throws Throwable{
        long start =System.currentTimeMillis();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------------------target is :" + pjp.getTarget()+"---------------------------");
        System.out.println("<<<<<< [start] method : " +pjp.getSignature().getName());



        Object result = pjp.proceed();


//        System.out.println("result="+result);
        System.out.println("[end] >>>>>" + (System.currentTimeMillis()-start));
        System.out.printf("%n%n%n");
        System.out.println();
        System.out.println();
        System.out.println();
        return  result;
    }
}
