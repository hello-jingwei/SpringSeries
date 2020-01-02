package com.example.token.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.token.util.TokenUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截
 */
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 实现token校验，除登录之外都进行token校验
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
//        Pattern.matches("^/(login)(/)?(.+)?$", request.getRequestURL());
        String token = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(token)) {
            // 1. token verify；
            DecodedJWT decodedJWT = TokenUtil.decode(token, DecodedJWT.class);
            if (decodedJWT == null) {
                response.getWriter().write("########## AUTH EXPIRED ############");
                return false;
            }

            // 2. return result：true or false；
            return true;
        }

        response.getWriter().write("########## AUTH FAILED ############");
        return false;
    }

}
