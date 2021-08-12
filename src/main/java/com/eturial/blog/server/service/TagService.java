package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.Tag;

import java.util.List;

/**
*
*/
public interface TagService {

    Tag getTagById(Long id);

    List<Tag> getAllTag();
}
