package com.example.token.api.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/")
public class ResponseController {

    @ResponseBody
    @RequestMapping( value = "get/{apiParam}", method = RequestMethod.GET)
    public String getApi(@PathVariable String apiParam) {
        return "get: " + apiParam;
    }

    @ResponseBody
    @RequestMapping( value = "put/{apiParam}", method = RequestMethod.PUT)
    public String getInfo(@PathVariable String apiParam) {
        return "put: " + apiParam;
    }

//    @ResponseBody
//    @RequestMapping(method = RequestMethod.GET, value = "getInfo")
//    public String getInfo(HttpServletRequest request) {
//        String apiParam = request.getParameter("apiParam");
//        return apiParam + " get info success";
//    }

}
