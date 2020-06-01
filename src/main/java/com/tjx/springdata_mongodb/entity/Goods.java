package com.tjx.springdata_mongodb.entity;


import java.util.List;

public class Goods {
    private String itemId; //1000
    private String title; //名称标题
    private Double price; //价格
    private Integer quantity; //数量
    private List<String> imgUrl; //图片路径

    public Goods(){

    }

    public Goods(String itemId, String title, Double price, Integer quantity, List<String> imgUrl) {
        this.itemId = itemId;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String>  getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "itemId='" + itemId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imgUrl=" + imgUrl +
                '}';
    }
}
