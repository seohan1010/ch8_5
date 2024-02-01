package com.example.ch8_5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
class Ch85ApplicationTests {

    @Autowired
    ApplicationContext ac;

    @Test
    void contextLoads() {
        System.out.println("ac = " + ac);
		System.out.println("ac.getClassLoader().getName() = " + ac.getClassLoader().getName());
		System.out.println("ac.getClass().getTypeName() = " + ac.getClass().getTypeName());

		System.out.println("ac.getBeanDefinitionCount() = " + ac.getBeanDefinitionCount());
        String[] str = ac.getBeanDefinitionNames();
		Ch85Application ch85=ac.getBean("ch85Application",Ch85Application.class);
		System.out.println("ch85 = " + ch85);
		for(String string:str)
		{
			System.out.println("bean is  = " + string);
		}
    }


}
