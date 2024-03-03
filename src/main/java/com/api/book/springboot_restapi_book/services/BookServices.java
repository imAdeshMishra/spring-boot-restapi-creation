package com.api.book.springboot_restapi_book.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.springboot_restapi_book.dao.BookRepo;
import com.api.book.springboot_restapi_book.entities.Book;

@Component
public class BookServices {
    // private static List<Book> books = new ArrayList<>();

    // static{
    //     books.add(new Book(123,"John Hick Thick","Java Programming"));
    //     books.add(new Book(124,"John Hick Thick","Java Programming"));
    //     books.add(new Book(125,"John Hick Thick","Java Programming"));
    // }

    @Autowired
    private BookRepo bookRepo;


    public List<Book> getAllBooks(){
        return (List<Book>)this.bookRepo.findAll();
    }
    
    public Book getBookById(int id){
        Book book = null;
        try {
            // book =books.stream().filter(e->e.getId() == id).findFirst().get();

            book = this.bookRepo.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b){
        // books.add(b);
        Book result = bookRepo.save(b);
        return result;
    }
    // public void deleteBook(int bookId) {
    //     books = books.stream().filter(book->{
    //         if (book.getId()!=bookId) {
    //             return true;
    //         }else return false;
    //     }).collect(Collectors.toList());
    // }


    public void deleteBook(int bookId) {
        // books = books.stream().filter(book-> book.getId()!=bookId).collect(Collectors.toList());

        bookRepo.deleteById(bookId);;
    }

    public void updateBook(Book book, int bookId) {
        // books = books.stream().map(b->{
        //     if (b.getId()!=bookId) {
        //         b.setAuthor(book.getAuthor());
        //         b.setBookName(book.getBookName());
        //     }
        //     return b;
        // }).collect(Collectors.toList());


        book.setId(bookId);
        bookRepo.save(book);
    }
        
    
}
