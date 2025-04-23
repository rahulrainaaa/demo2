package com.example.demo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom-endpoint")
public class CustomEndPoint {

    @ReadOperation
    public String getServerInfo() {
        // You can return any custom information here
        return "Server is up and running. IP: 192.168.1.1, Name: MyServer";
    }
}
