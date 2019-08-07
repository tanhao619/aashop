package com.th.demo.modular.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;

/**
 * Created by 86514 on 2019/7/5.
 */
@TableName("bill")
public class Bill {
    private Integer id;
    private Integer shop_id;
    private String userToken;
    private String debtPeople;
    private BigDecimal money;
    private Integer status;
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getDebtPeople() {
        return debtPeople;
    }

    public void setDebtPeople(String debtPeople) {
        this.debtPeople = debtPeople;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", shop_id='" + shop_id + '\'' +
                ", userToken='" + userToken + '\'' +
                ", debtPeople='" + debtPeople + '\'' +
                ", money=" + money +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
