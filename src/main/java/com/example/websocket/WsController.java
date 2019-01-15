package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    @Autowired
    public SimpMessagingTemplate template;

    @MessageMapping("/queue")
    public void queuw(WiselyMessage rm) {
            /*广播使用convertAndSendToUser方法，第一个参数为用户id，此时js中的订阅地址为
            "/user/" + 用户Id + "/message",其中"/user"是固定的*/
            template.convertAndSendToUser("zhangsan","/message",rm.getName());
        }

}