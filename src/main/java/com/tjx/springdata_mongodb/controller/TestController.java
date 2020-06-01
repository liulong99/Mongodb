package com.tjx.springdata_mongodb.controller;

import com.tjx.springdata_mongodb.entity.Comment;
import com.tjx.springdata_mongodb.entity.Xyj;
import com.tjx.springdata_mongodb.service.CommentService;
import com.tjx.springdata_mongodb.service.TestService;
import com.tjx.springdata_mongodb.service.XyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class TestController {


    @Autowired
    private TestService testService;


    //测试不同集合多文档事务
    @GetMapping("/test")
    public String test(){
        testService.test();
        return "aaa";
    }
}
