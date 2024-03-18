package com.kidsnotehelper.common.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HelloController {

    private static Environment environment;

    @GetMapping
    public ResponseEntity index(HttpServletRequest request) {

        return ResponseEntity.ok("index Page. \n " + getServerInfo());
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("hello");
    }

    private String getServerInfo() {
        try {
            // Port
            String port = environment.getProperty("server.port");

            // Local address
            String localHostAddress = InetAddress.getLocalHost().getHostAddress();
            String localHostName = InetAddress.getLocalHost().getHostName();

            // Remote address
            String remoteHostAddress = InetAddress.getLoopbackAddress().getHostAddress();
            String remoteHostName = InetAddress.getLoopbackAddress().getHostName();

            return "port : " + port + "\n" +
                    "localHostAddress : " + localHostAddress + "\n" +
                    "localHostName : " + localHostName + "\n" +
                    "remoteHostAddress : " + remoteHostAddress + "\n" +
                    "remoteHostName : " + remoteHostName + "\n";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
