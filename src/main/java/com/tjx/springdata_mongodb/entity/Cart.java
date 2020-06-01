package com.tjx.springdata_mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "cart")
public class Cart {
    @Id
    private String id;   //主键

    private String userId; //用户id
    private Date lastActivity;//最后活跃时间
    private String status; //状态

    private List<Goods> goods;

    public Cart(){

    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", lastActivity=" + lastActivity +
                ", status='" + status + '\'' +
                ", goods=" + goods +
                '}';
    }

    public Cart(String userId, Date lastActivity, String status, List<Goods> goods) {
        this.userId = userId;
        this.lastActivity = lastActivity;
        this.status = status;
        this.goods = goods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
