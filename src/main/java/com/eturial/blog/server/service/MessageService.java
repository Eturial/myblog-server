package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.Message;

import java.util.List;

/**
*
*/
public interface MessageService {

    Message getOneById(Long id);

    List<Message> getAllMessage();

    void addMessage(Message message);

    void deleteOne(Long id);
}
