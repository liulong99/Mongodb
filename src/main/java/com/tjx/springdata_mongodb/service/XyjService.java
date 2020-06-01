package com.tjx.springdata_mongodb.service;

import com.tjx.springdata_mongodb.dao.XyjDao;
import com.tjx.springdata_mongodb.entity.Xyj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class XyjService {

    @Autowired
    private XyjDao xyjDao;

    @Autowired
    private MongoTemplate mongoTemplate;

     public List<Xyj> saveAll(List<Xyj> comments){
         return  xyjDao.saveAll(comments);
     }

    public List<Xyj> findAll(){
        return xyjDao.findAll();
    }

    public List<Xyj> findAll(Sort var1){
        return xyjDao.findAll(var1);
    }

    @Transactional
    public Xyj insert(Xyj var1){
        Xyj insert = xyjDao.insert(var1);
        System.out.println(1/0);
        return insert;
    }

    public void updateLikenum(String id,int count){
        Query query=Query.query(Criteria.where("_id").is(id));  //查询条件
        Update update=new Update();
        update.inc("likenum");
        mongoTemplate.updateFirst(query,update,Xyj.class);
    }
}
