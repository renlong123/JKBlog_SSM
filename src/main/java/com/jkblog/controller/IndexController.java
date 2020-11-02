package com.jkblog.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class IndexController {


    @GetMapping({"/index","/","/hello"})
    public String index(){
        log.info("logback测试!");
        log.info("{},我来了","hi");
        return "hello";
    }
}
