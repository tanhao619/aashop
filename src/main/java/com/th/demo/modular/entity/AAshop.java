package com.th.demo.modular.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;

/**
 * Created by Tanhao on 2018/3/21.
 */
@TableName("shop")
public class AAshop {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String remark;
    private String createTime;
    private String userToken;
    private String containPeople;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getContainPeople() {
        return containPeople;
    }

    public void setContainPeople(String containPeople) {
        this.containPeople = containPeople;
    }
}
