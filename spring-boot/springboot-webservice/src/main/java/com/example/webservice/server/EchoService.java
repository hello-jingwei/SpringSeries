package com.example.webservice.server;

import javax.jws.WebService;

@WebService
public class EchoService {

    public String echo(String user){
        return user + " here is webservice";
    }
}
