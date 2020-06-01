package com.tjx.springdata_mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "comment")
@CompoundIndex(def = "{userid: 1,parentid: -1}")
public class Comment implements Serializable{

    @Id
    private String id;   //主键


    @Field("content")
    private String content; //吐槽内容
    private Date publishtime;//发布时间

    @Indexed
    private String userid; //发布人ID
    private String nickname; //昵称
    private LocalDateTime createdatetime; //评论时间
    private Integer likenum; //点赞数
    private Integer replunum; //回复数
    private String state; //状态
    private String parentid; //上级ID
    private String articleid;

    public Comment() {
    }

    public Comment(String id, String content, Date publishtime, String userid, String nickname, LocalDateTime createdatetime, Integer likenum, Integer replunum, String state, String parentid, String articleid) {
        this.id = id;
        this.content = content;
        this.publishtime = publishtime;
        this.userid = userid;
        this.nickname = nickname;
        this.createdatetime = createdatetime;
        this.likenum = likenum;
        this.replunum = replunum;
        this.state = state;
        this.parentid = parentid;
        this.articleid = articleid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", publishtime=" + publishtime +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createdatetime=" + createdatetime +
                ", likenum=" + likenum +
                ", replunum=" + replunum +
                ", state='" + state + '\'' +
                ", parentid='" + parentid + '\'' +
                ", articleid='" + articleid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(LocalDateTime createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getReplunum() {
        return replunum;
    }

    public void setReplunum(Integer replunum) {
        this.replunum = replunum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }
}
