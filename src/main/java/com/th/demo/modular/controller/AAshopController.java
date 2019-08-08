package com.th.demo.modular.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.th.demo.common.tips.Tip;
import com.th.demo.modular.entity.AAshop;
import com.th.demo.modular.service.IAAshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tanhao on 2018/3/21.
 */

@RestController
@RequestMapping("/api/v2")
@Api(value = "AAshop", description = "AA购物账单")
public class AAshopController {
    private final static Logger logger = LoggerFactory.getLogger(AAshopController.class);
    @Autowired
    private IAAshopService IAAshopService;

    @ApiOperation(value="账单列表详情", notes="账单列表详情",response = HttpMessage.class)
    @GetMapping("/aashop/lists")
    public Tip listPage(
            @ApiParam(value = "页码。默认第一页(起始索引为1)",defaultValue = "1") @RequestParam(value="pagenum", required=false, defaultValue = "1") Integer pagenum,
            @ApiParam(value = "每页大小,默认为10", defaultValue = "10") @RequestParam(value="pagesize", required=false, defaultValue = "10") Integer pagesize,
            @ApiParam(value = "姓名模糊检索") @RequestParam(value = "searchvalue", required = false) String searchvalue,
            @ApiParam(value = "用户标识",required = true) @RequestParam(value = "userToken") String userToken
    ) throws Exception{
        Page page=new Page(pagenum,pagesize);
        return IAAshopService.getAAList(page, searchvalue,userToken);
    }

    @ApiOperation(value="我的账单列表", notes="我的账单列表",response = HttpMessage.class)
    @GetMapping("/aashop/mylist")
    public Tip mylist(
            @ApiParam(value = "页码。默认第一页(起始索引为1)",defaultValue = "1") @RequestParam(value="pagenum", required=false, defaultValue = "1") Integer pagenum,
            @ApiParam(value = "每页大小,默认为10", defaultValue = "10") @RequestParam(value="pagesize", required=false, defaultValue = "10") Integer pagesize,
            @ApiParam(value = "用户标识",required = true) @RequestParam(value = "userToken") String userToken
    ) throws Exception{
        Page page=new Page(pagenum,pagesize);
        return IAAshopService.getMylist(page,userToken);
    }

    @ApiOperation(value="每个人给的钱", notes="每个人给的钱",response = HttpMessage.class)
    @GetMapping("/aashop/everyonePay")
    public Tip everyonePay(
            @ApiParam(value = "页码。默认第一页(起始索引为1)",defaultValue = "1") @RequestParam(value="pagenum", required=false, defaultValue = "1") Integer pagenum,
            @ApiParam(value = "每页大小,默认为10", defaultValue = "10") @RequestParam(value="pagesize", required=false, defaultValue = "10") Integer pagesize,
            @ApiParam(value = "用户标识",required = true) @RequestParam(value = "userToken") String userToken
    ) throws Exception{
        Page page = new Page(pagenum,pagesize);
        return IAAshopService.everyonePay(page,userToken);
    }

    @ApiOperation(value="账单详情", notes="账单详情",response = HttpMessage.class)
    @GetMapping("/aashop/details/{id}")
    public Tip getDetail( @ApiParam(value = "id",required = true) @PathVariable(required = true) Integer id
    ) throws Exception{
        return IAAshopService.getDetail(id);
    }

    @ApiOperation(value="增加账单", notes="增加账单",response = HttpMessage.class)
    @PostMapping("/aashop/insert")
    public Tip insert( @ApiParam(value = "shop",required = true) @RequestBody AAshop shop
    ) throws Exception{
        return IAAshopService.insertAAshop(shop);
    }

    @ApiOperation(value="登录", notes="登录",response = HttpMessage.class)
    @PostMapping("/aashop/login")
    public Tip login( @ApiParam(value = "userName",required = true) @RequestParam String userName,
                      @ApiParam(value = "passWord",required = true) @RequestParam String passWord
    ) throws Exception{
        return IAAshopService.login(userName,passWord);
    }

    @ApiOperation(value="结算", notes="结算",response = HttpMessage.class)
    @PutMapping("/aashop/account")
    public Tip account() throws Exception{
        return  IAAshopService.account();
    }
}
