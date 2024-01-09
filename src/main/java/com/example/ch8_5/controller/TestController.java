package com.example.ch8_5.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testMethod(HttpServletRequest request, HttpServletResponse response) {

        Enumeration enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
            String name = (String) enumeration.nextElement();



        }

        System.out.println("response.toString() = " + request.getRequestURL());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getMethod() = " + request.getMethod());
        if(!request.getMethod().equals("GET"))
        System.out.println("request.getParameter(\"nene\").length() = " + request.getParameter("nene").length());

        System.out.println(""==null);
        System.out.println("".equals(null));

        return "this is test controller : " + request.getHeader("hehe");
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)

    public void testMethod2(@RequestBody Object obj, HttpServletRequest request) {

        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println(request.getServletContext());
        System.out.println("obj = " + obj);
        Map<String, String> map = (Map<String, String>) obj;
        System.out.println("map.get(\"nene\") = " + map.get("nene"));
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getServletContext() = " + request.getServletContext());
        System.out.println("request.getDispatcherType() = " + request.getDispatcherType());
        System.out.println("request.getMethod() = " + request.getMethod());

        try {
            System.out.println("request.getReader() = " + request.getReader());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("request.getContextPath() = " + request.getContextPath());

    }


}
