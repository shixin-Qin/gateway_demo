package com.example.service_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version application.yml.0.0
 * @createTime 2021/11/29 10
 */
@Slf4j
@RestController
@RequestMapping("/send")
public class SendController {
    
    private int count = 0;
    
    @RequestMapping("/hello")
    public String hello() {
        log.info("hello:{}", count++);
        return "hello";
    }
    
}
