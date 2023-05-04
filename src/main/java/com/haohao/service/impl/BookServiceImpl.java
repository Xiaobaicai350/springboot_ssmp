package com.haohao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.dao.BookDao;
import com.haohao.entity.Book;
import com.haohao.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
}
