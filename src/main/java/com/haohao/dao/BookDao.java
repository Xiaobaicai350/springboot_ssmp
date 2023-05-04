package com.haohao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haohao.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}