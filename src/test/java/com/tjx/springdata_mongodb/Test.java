package com.tjx.springdata_mongodb;

import com.tjx.springdata_mongodb.entity.Comment;
import com.tjx.springdata_mongodb.entity.Xyj;
import com.tjx.springdata_mongodb.service.CommentService;
import com.tjx.springdata_mongodb.service.XyjService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionAnnotationParser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class Test {

    @Autowired
    private CommentService commentService;

    @org.junit.Test
    public void testSaveAll(){
        List<Comment> comments=new ArrayList<>();
        comments.add(new Comment("1003","写得很好，赞",new Date(),"888","苏沐秋", LocalDateTime.now(),40,20,"0","","10038"));
        comments.add(new Comment("1004","收获很大",new Date(),"999","苏沐橙", LocalDateTime.now(),40,20,"0","","10038"));
        commentService.saveAll(comments);
    }

    @org.junit.Test
    public void testFindAll(){
        System.out.println(commentService.findAll());
    }

    //单集合多文档事务
    @org.junit.Test
    @Transactional(rollbackFor = {Exception.class})
    public void testInsert(){
        Comment comment = new Comment("1011", "收获很大", new Date(), "1000", "叶秋", LocalDateTime.now(), 40, 20, "0", "10038", "10038");
        commentService.insert(comment);

        Comment comment2 = new Comment("1012", "收获很大", new Date(), "1000", "叶秋", LocalDateTime.now(), 40, 20, "0", "10038", "10038");
        commentService.insert(comment2);
        System.out.println(1/0);
    }

    @org.junit.Test
    public void  testInserts(){
        List<Comment> comments=new ArrayList<>();
        comments.add(new Comment("1004","写得很好，赞",new Date(),"888","苏沐秋", LocalDateTime.now(),40,20,"0","10038","10038"));
        comments.add(new Comment("1005","收获很大",new Date(),"999","苏沐橙", LocalDateTime.now(),40,20,"0","10038","10038"));
        commentService.insert(comments);
    }

    @org.junit.Test
    public void testRemove(){
        Comment comment = new Comment();
        comment.setId("1001");
        commentService.remove(comment);
    }


    @org.junit.Test
    public void findByParentid(){
        Page<Comment> byParentid = commentService.findByParentid("10038", 1, 2);
        System.out.println(byParentid.getTotalElements());
        List<Comment> content = byParentid.getContent();
        System.out.println(content);
    }


    @org.junit.Test
    public void updateLikenum(){
        commentService.updateLikenum("1002",1);
    }

}
