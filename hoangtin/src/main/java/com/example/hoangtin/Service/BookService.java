package com.example.hoangtin.Service;

import com.example.hoangtin.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private List<Book> listBook = new ArrayList<>(Arrays.asList(
            new Book(1, "Lap trinh window", "Tran Hoang Tin", 2000),
            new Book(2, "Cau truc du lieu va giai thuat", "Hoang Anh", 3000),
            new Book(3, "Ky thuat lap trinh", "Phi Long", 4000),
            new Book(4, "Co so du lieu", "Nguyễn Kim Kha", 5000)));
    public List<Book> getAll()
    {
        return listBook;
    }
    public Book get(int id)
    {
        var findBook = listBook.stream().filter(p->p.getId()== id).findFirst().orElse(null);
        if(findBook == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return findBook;
    }
    public void add(Book newbook)
    {
        var maxId = listBook
                .stream()
                .mapToInt(v -> v.getId())
                .max().orElse( 0);
        newbook.setId(maxId +1);
        listBook.add(newbook);
    }
    public void remove(int id)
    {
        var findBook = listBook.stream().filter(p->p.getId() == id).findFirst().orElseThrow();
        listBook.remove(findBook);
    }
    public List<Book> search(String key)
    {
        return listBook.stream().filter(p->p.getAuthor().toLowerCase().contains(key) || p.getTitle().toLowerCase().contains(key)).toList();
    }
}
