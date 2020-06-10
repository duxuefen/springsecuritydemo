package com.springsecurity.springsecuritydemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "product",type = "phone")
public class Product {
    @Id
    @Field(type = FieldType.Integer,index = false,store = true)
    private Integer id;
    @Field(type=FieldType.Text,index = true,store = true,analyzer = "ik_max_word")
    private String pname;
    @Field(type = FieldType.Double,index = false,store = true)
    private Double pprice;
    @Field(type=FieldType.Text,index = true,store = true,analyzer = "ik_max_word")
    private String picon;
    @Field(type=FieldType.Text,index = true,store = true,analyzer = "ik_max_word")
    private String shopname;
    @Field(type=FieldType.Text,index = true,store = true,analyzer = "ik_max_word")
    private String pstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public String getPicon() {
        return picon;
    }

    public void setPicon(String picon) {
        this.picon = picon == null ? null : picon.trim();
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate == null ? null : pstate.trim();
    }
}