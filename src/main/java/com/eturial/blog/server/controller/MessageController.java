package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.pojo.Message;
import com.eturial.blog.server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping(value = "/addMessage")
    @ResponseBody
    // 留言
    public void addMessage(@RequestBody JSONObject object) {
        Message message = new Message();
        message.setContent(object.getString("content"));
        message.setNickname(object.getString("nickname"));
        message.setParentMessageId(object.getLong("parentId"));

        messageService.addMessage(message);
    }

    @GetMapping(value = "/getOne")
    @ResponseBody
    // 获取单条
    public Message addMessage(@RequestParam("id") Long id) {
        return messageService.getOneById(id);
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    // 获取全部
    public List<Message> getAllMessage() {
        return messageService.getAllMessage();
    }

    @PostMapping(value = "/deleteOne")
    @ResponseBody

    public void deleteOne(@RequestParam("id") Long id) {
        messageService.deleteOne(id);
    }
}
