package com.well.mqservice.controller;

import com.well.mqservice.init.Recv;
import com.well.mqservice.init.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwell
 */
@RestController
@RequestMapping("/message")
public class SendController {

    @Autowired
    private Send sender;

    @Autowired
    private Recv receiver;

    @GetMapping("/send")
    public String sendMsg(@RequestParam(name = "msg") String msg) {
        sender.sendMsg(msg);
        return receiver.recv();
    }
}
