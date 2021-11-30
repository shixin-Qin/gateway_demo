package com.example.service_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version application.yml.0.0
 * @createTime 2021/11/29 10
 */
@RestController
@RequestMapping("/send")
public class SendController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    
}
