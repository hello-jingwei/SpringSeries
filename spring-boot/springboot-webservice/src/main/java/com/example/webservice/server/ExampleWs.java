package com.example.webservice.server;

import javax.xml.ws.Endpoint;

public class ExampleWs {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8080/ws_server",new EchoService());
    }
}
