package com.th.demo.filter;

import com.th.demo.common.BizExceptionEnum;
import com.th.demo.common.BussinessException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UserInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!request.getServletPath().equals("/qbs/User/tblogIn") && !request.getServletPath().equals("/qbs/User/logInRegister")
                && !request.getServletPath().equals("/qbs/User/thirdLogin") && !request.getServletPath().equals("/qbs/common/stuad")) {
            String token = request.getParameter("token_id");
            final String userId = request.getParameter("user_id");
            if (!StringUtils.isEmpty(token) && !StringUtils.isEmpty(userId)){
                Map map = null;
                if (null != map){
                    String status = String.valueOf(map.get("status"));
                    if (!StringUtils.isEmpty(status) && status.equals("2")){//账号被冻结
                        throw new BussinessException(BizExceptionEnum.FAIL_LOGIN);
                    }
                    String tokenId = map.get("token").toString();
                    if (!token.equals(tokenId)){
                        throw new BussinessException(BizExceptionEnum.FAIL_LOGIN);
                    }
                }else {
                    throw new BussinessException(BizExceptionEnum.FAIL_LOGIN);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}