package com.example.token.user.service;

import com.example.token.user.entity.UserInfo;
import com.example.token.util.TokenUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * login simulation
     * @return
     */
    public String getToken(String userName, String password) {
        if("Lee".equals(userName) && "123456".equals(password)) {
            return TokenUtil.sign(userName, password);
        } else {
            return "failed";
        }
    }

}
