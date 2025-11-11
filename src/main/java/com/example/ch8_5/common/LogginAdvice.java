package com.example.ch8_5.common;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogginAdvice {

    @Around("execution(* com.example.ch8_5.controller.*.*(..))") // pointcut(패턴, 어떤 메서드에 적용할지를 지정)
    public Object methodCallLog(ProceedingJoinPoint pjp)throws Throwable{
        long start =System.currentTimeMillis();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------------------target is :" + pjp.getTarget()+"---------------------------");
        System.out.println("<<<<<< [start] method : " +pjp.getSignature().getName());



        Object result = pjp.proceed(); // 타겟의 메서드를 호출 (Throwable 예외를 발생)


//        System.out.println("result="+result);
        System.out.println("[end] >>>>>" + (System.currentTimeMillis()-start));
        System.out.printf("%n%n%n");
        System.out.println();
        System.out.println();
        System.out.println();
        return  result;
    }
}
