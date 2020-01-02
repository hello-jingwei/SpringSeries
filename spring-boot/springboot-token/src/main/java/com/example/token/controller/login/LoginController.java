package com.example.token.controller.login;

import com.example.token.user.entity.UserInfo;
import com.example.token.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam Map<String,Object> userInfo) {
        String userName = userInfo.get("userName").toString();
        String password = userInfo.get("password").toString();

        String token = userService.getToken(userName, password);
        if(!"failed".equals(token)) {
            return "{\"result\":\"login success\"," + "\"token\":" + "\"" + token + "\"}";
        } else {
            return "login failed";
        }
    }
}
