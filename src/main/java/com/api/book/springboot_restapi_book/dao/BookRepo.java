package com.api.book.springboot_restapi_book.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.springboot_restapi_book.entities.Book;

public interface BookRepo extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
