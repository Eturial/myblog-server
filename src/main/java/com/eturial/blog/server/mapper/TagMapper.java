package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.Tag
*/
@Mapper
public interface TagMapper {

    List<Tag> getAllTag();

    Tag getTagById(@Param("id") Long id);
}
