package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.pojo.Tag;
import com.eturial.blog.server.service.TagService;
import com.eturial.blog.server.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }
}
