package com.tjx.springdata_mongodb.dao;

import com.tjx.springdata_mongodb.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentDao extends MongoRepository<Comment,String>{

    //根据命名规则   springdata会帮我们自动实现此方法
    Page<Comment> findByParentid(String parent, Pageable pageable);


}
