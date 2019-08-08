package com.th.demo.common;

/**
 * 所有业务异常的枚举
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:04:51
 */
public enum BizExceptionEnum {

    SUCCESS(200,"操作成功"),

    FAIL_LOGIN(501,"登录失败，用户名或密码错误"),
    EMPTY_ERROR(502,"userToken不能为空"),
    EMPTY_LOGIN(503,"请输入用户名密码")
    ;
    BizExceptionEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }


    private int friendlyCode;

    private String friendlyMsg;

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

}
