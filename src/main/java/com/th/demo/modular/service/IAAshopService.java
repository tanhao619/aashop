package com.th.demo.modular.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.th.demo.common.tips.Tip;
import com.th.demo.modular.entity.AAshop;

/**
 * Created by Tanhao on 2018/3/21.
 */
public interface IAAshopService {
     Tip getAAList(Page page, String searchvalue,String userToken) throws Exception;

     Tip getDetail(Integer id) throws Exception;

     Tip insertAAshop(AAshop shop) throws Exception;

     Tip login(String userName, String passWord) throws Exception;

     Tip account();

     Tip getMylist(Page page, String userToken);

     Tip everyonePay(Page page, String userToken);

     Tip peopleDetail();
}
