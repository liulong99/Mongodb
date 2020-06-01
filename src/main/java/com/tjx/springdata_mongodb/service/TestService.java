package com.tjx.springdata_mongodb.service;

import com.tjx.springdata_mongodb.dao.CommentDao;
import com.tjx.springdata_mongodb.dao.XyjDao;
import com.tjx.springdata_mongodb.entity.Comment;
import com.tjx.springdata_mongodb.entity.Xyj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class TestService {


    @Autowired
    XyjDao xyjDao;


    @Autowired
    CommentDao commentDao;


    //不同集合多文档事务
    @Transactional
    public String test(){
        Comment comment = new Comment("1001", "收获很大", new Date(), "1000", "叶秋", LocalDateTime.now(), 40, 20, "0", "10038", "10038");
        commentDao.insert(comment);
        Xyj xyj=new Xyj("1001","唐生");
        xyjDao.insert(xyj);
        System.out.println(1/0);
        return "aaa";
    }


}
