package com.th.demo.modular.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.th.demo.modular.entity.AAshop;
import com.th.demo.modular.entity.Bill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Tanhao on 2018/3/22.
 */
@Component
public interface AAshopMapper extends BaseMapper<AAshop> {
    List<AAshop> getList(Page page,@Param("value") String value);

    Integer login(@Param("userName")String userName, @Param("passWord")String passWord);

    void account();

    List<AAshop> getMylist(Page page,@Param("userToken") String userToken);

    List<Map> getEveryonePay(Page page, @Param("userToken") String userToken);

    void insertBill(Bill bill);

    String getMyMoneyInfo(@Param("userToken") String userToken);
}
