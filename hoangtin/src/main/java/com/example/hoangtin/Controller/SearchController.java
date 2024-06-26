package com.example.hoangtin.Controller;

import com.example.hoangtin.model.Book;
import com.example.hoangtin.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private BookService bookService;
    @GetMapping("/search")
    public List<Book>
    search(@RequestParam String key)
    {
        return bookService.search(key);
    }
}
