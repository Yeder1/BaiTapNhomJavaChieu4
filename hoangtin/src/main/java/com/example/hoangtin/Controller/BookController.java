package com.example.hoangtin.Controller;

import com.example.hoangtin.model.Book;
import com.example.hoangtin.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<Book> GetAll() {
        return bookService.getAll();
    }
    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id)
    {
        return bookService.get(id);
    }
    @PostMapping("/books")
    public Book create(@RequestBody   Book book)
    {
        bookService.add(book);
        return book;
    }
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int   id)
    {
        bookService.remove(id);
    }
}
