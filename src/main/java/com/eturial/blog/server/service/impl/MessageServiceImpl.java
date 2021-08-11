package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.pojo.Message;
import com.eturial.blog.server.service.MessageService;
import com.eturial.blog.server.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public Message getOneById(Long id) {
        return messageMapper.getOneById(id);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public void addMessage(Message message) {
        if(message.getParentMessageId() == null)
            message.setParentMessageId(0L);
        messageMapper.addMessage(message);
    }

    @Override
    public void deleteOne(Long id) {
        messageMapper.deleteOne(id);
    }
}
