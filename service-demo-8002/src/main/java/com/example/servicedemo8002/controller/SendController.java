package com.example.servicedemo8002.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/12/1 11
 */
@RestController
@RequestMapping("/send")
public class SendController {
    
    @RequestMapping("/hello")
    public String hello(@RequestParam("colour") String colour) {
        return colour;
    }
}
