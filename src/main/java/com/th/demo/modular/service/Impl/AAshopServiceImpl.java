package com.th.demo.modular.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.th.demo.common.BizExceptionEnum;
import com.th.demo.common.BussinessException;
import com.th.demo.common.ResultUtil;
import com.th.demo.common.SuccessResultEnum;
import com.th.demo.common.tips.Tip;
import com.th.demo.modular.entity.AAshop;
import com.th.demo.modular.service.IAAshopService;
import com.th.demo.modular.dao.AAshopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tanhao on 2018/3/21.
 */
@Service
@Transactional
public class AAshopServiceImpl extends ServiceImpl<AAshopMapper, AAshop> implements IAAshopService {
    private static final Logger logger = LoggerFactory.getLogger(AAshopServiceImpl.class);
    @Autowired
    private AAshopMapper AAshopMapper;

    /**
     * 列表
     */
    @Override
    public Tip getAAList(Page page, String searchvalue, String userToken) throws Exception {
        if (StringUtils.isEmpty(userToken)) {
            return ResultUtil.result(BizExceptionEnum.EMPTY_ERROR.getCode(), BizExceptionEnum.EMPTY_ERROR.getMessage());
        }
        List<AAshop> shop = AAshopMapper.getList(page, searchvalue);
        //我购买的东西列表
        List<AAshop> meList = shop.stream().filter(p -> p.getUserToken().equals(userToken)).collect(Collectors.toList());
        //我购买的价格总和
        BigDecimal meTotal = meList.stream().map(AAshop::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        //别人购买的东西列表
        List<AAshop> otherList = shop.stream().filter(p -> !p.getUserToken().equals(userToken)).collect(Collectors.toList());
        //别人购买的东西价格总和
        BigDecimal otherTotal = otherList.stream().map(AAshop::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        //差价
        BigDecimal total = meTotal.subtract(otherTotal);
        JSONObject result = new JSONObject(true);
        result.put("total", total);
        result.put("meTotal", meTotal);
        result.put("otherTotal", otherTotal);
        result.put("me", meList);
        result.put("other", otherList);
        //加日志
        addLogToTXT(userToken,String.valueOf(total),String.valueOf(meTotal),String.valueOf(otherTotal));
        return ResultUtil.result(SuccessResultEnum.SUCCESS.getCode(), SuccessResultEnum.SUCCESS.getMessage(), result);
    }

    /**
     * 详情
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Tip getDetail(Integer id) throws Exception {
        AAshop detail = AAshopMapper.selectById(id);
        return ResultUtil.result(SuccessResultEnum.SUCCESS.getCode(), SuccessResultEnum.SUCCESS.getMessage(), detail == null ? "" : detail);
    }

    /**
     * 增加账单
     * @param shop
     * @return
     * @throws Exception
     */
    @Override
    public Tip insertAAshop(AAshop shop) throws Exception {
        if (StringUtils.isEmpty(shop.getUserToken())) {
            return ResultUtil.result(BizExceptionEnum.EMPTY_ERROR.getCode(), BizExceptionEnum.EMPTY_ERROR.getMessage());
        }
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shop.setCreateTime(smf.format(new Date()));
        AAshopMapper.insert(shop);
        return ResultUtil.result(SuccessResultEnum.SUCCESS.getCode(), SuccessResultEnum.SUCCESS.getMessage());
    }

    /**
     * 登录
     * @param userName
     * @param passWord
     * @return
     * @throws Exception
     */
    @Override
    public Tip login(String userName, String passWord) throws Exception {
        Integer count = AAshopMapper.login(userName, passWord);
        if (count == 0) {
            throw new BussinessException(BizExceptionEnum.FAIL_LOGIN);
        }
        return ResultUtil.result(SuccessResultEnum.SUCCESS.getCode(), SuccessResultEnum.SUCCESS.getMessage());
    }

    /**
    结算
     */
    @Override
    public Tip account() {
        AAshopMapper.account();
        return ResultUtil.result(SuccessResultEnum.SUCCESS.getCode(), SuccessResultEnum.SUCCESS.getMessage());
    }

    /**
     * 日志打印
     * @param userToken
     * @param total
     * @param meTotal
     * @param otherTotal
     * @throws Exception
     */
    private static void addLogToTXT(String userToken,String total,String meTotal,String otherTotal) throws Exception {
        File writename = new File("aalog.txt");
        if(!writename.exists()){
            writename.createNewFile(); // 创建新文件
        }
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(writename, true)));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        out.write(now+"：用户*"+userToken+"*——所用金额："+meTotal+"元,他人所用金额："+otherTotal+ "元，累计差价为："+total+"元\r\n"); // \r\n即为换行
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }

}
