package com.chadi.aws.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @Value("${aws.accesKeyId}")
    private String awsAccessKeyId;

    @GetMapping({ "hello"})
    public String helloWorld() {
        return "hello-world";
    }

    @GetMapping("test")
    public String test() {
      String test= System.getenv("accesKeyId");
        return "test " +awsAccessKeyId + " online " + test;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }
}
