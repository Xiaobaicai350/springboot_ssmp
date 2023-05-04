package com.haohao.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haohao.entity.Book;
import com.haohao.service.BookService;
import com.haohao.utils.R;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll(){
        List<Book> list = bookService.list();
        R r = new R(true, list);
        return r;
    }

    @PostMapping
    public R save(@RequestBody Book book){
        boolean b = bookService.save(book);
        R r = new R(b,null);
        return r;
    }

    @PutMapping
    public R update(@RequestBody Book book){
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Book::getId,book.getId());
        boolean b = bookService.update(book, queryWrapper);
        R r = new R(b, null);
        return r;
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        boolean b = bookService.removeById(id);
        R r = new R(b, null);
        return r;
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        R r = new R(true, book);
        return r;
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book queryBook){
        //增加book，也就是分页
        Page<Book> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(queryBook.getName()),Book::getName,queryBook.getName());
        lqw.like(Strings.isNotEmpty(queryBook.getType()),Book::getType,queryBook.getType());
        lqw.like(Strings.isNotEmpty(queryBook.getDescription()),Book::getDescription,queryBook.getDescription());
        page = bookService.page(page,lqw);
        R r = new R(true, page);
        return r;
    }
}