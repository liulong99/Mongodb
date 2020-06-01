package com.tjx.springdata_mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Document(collection="xyj")
public class Xyj implements Serializable{

    @Id
    private String id;   //主键

    private String name;

    public Xyj(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Xyj() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
