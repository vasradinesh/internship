package com.springboot.library_management.controller;

import com.springboot.library_management.Models.Book;
import com.springboot.library_management.service.serviceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class Controller {

    @Autowired
    private serviceBook serviceBook;

    @PostMapping()
    public String Add_book(@RequestBody Book book) {
        return serviceBook.Add_book(book);
    }

    @GetMapping
    public List<Book> Get_all_books() {
        return serviceBook.Get_all_books();
    }

    @GetMapping("/{bid}")
    public Book Get_book_by_ID(@PathVariable Long bid) {
        return serviceBook.Get_book_by_ID(bid);
    }

    @PutMapping("/{bid}")
    public String Update_book_By_Id(@PathVariable Long bid, @RequestBody Book book) {
        return serviceBook.Update_book_By_Id(bid,book);
    }

    @DeleteMapping("/{bid}")
    public String Delete_book_By_Id(@PathVariable Long bid) {
        return serviceBook.Delete_book_By_Id(bid);
    }

    @GetMapping("/search/title/{title}")
    public Book Search_by_title(@PathVariable String title) {
        return serviceBook.Search_by_title(title);
    }

    @GetMapping("search/author/{author}")
    public Book Search_by_Author(@PathVariable String author) {
        return serviceBook.Search_by_Author(author);
    }

    @GetMapping("count")
    public long Count_books() {
        return serviceBook.Count_books();
    }

    @GetMapping("sort/price")
    public List<Book> Sort_by_price() {
        return serviceBook.Sort_by_price();
    }

    @PostMapping("bulk")
    public String Bulk_add(@RequestBody List<Book> books) {
        return serviceBook.Bulk_add(books);
    }

    @DeleteMapping("delete_all")
    public String Delete_all_Books() {
        return serviceBook.Delete_all_Books();
    }
}
