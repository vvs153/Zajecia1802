package com.sda.zadanie1802.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/student")
public class DemoController {
    @GetMapping("/hello")
    public String getHello(){
        log.info("dupa");
        return "helo biden";
    }
}
