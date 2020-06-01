package com.tjx.springdata_mongodb.service;

import com.tjx.springdata_mongodb.dao.CommentDao;
import com.tjx.springdata_mongodb.dao.XyjDao;
import com.tjx.springdata_mongodb.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;


    @Autowired
    private MongoTemplate mongoTemplate;

     public List<Comment> saveAll(List<Comment> comments){
         return  commentDao.saveAll(comments);
     }

    public List<Comment> findAll(){
        return commentDao.findAll();
    }

    public List<Comment> findAll(Sort var1){
        return commentDao.findAll(var1);
    }

    @Transactional
    public Comment insert(Comment var1){
        Comment insert = commentDao.insert(var1);
        return insert;
    }

    public List<Comment> insert(List<Comment> comments){
        return commentDao.insert(comments);
    }

    public List<Comment> findAll(Example<Comment> example){
        return commentDao.findAll(example);
    }

    public List<Comment> findAll(Example<Comment> var1, Sort var2){
        return commentDao.findAll(var1,var2);
    }

    public void remove(Comment var1){
         commentDao.delete(var1);
    }


    public Page<Comment> findByParentid(String parent, int page, int size){
        return commentDao.findByParentid(parent, PageRequest.of(page-1,size));
    }

    public void updateLikenum(String id,int count){
        Query query=Query.query(Criteria.where("_id").is(id));  //查询条件
        Update update=new Update();
        update.inc("likenum");
        mongoTemplate.updateFirst(query,update,Comment.class);
    }
}
