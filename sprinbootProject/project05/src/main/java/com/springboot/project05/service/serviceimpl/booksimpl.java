package com.springboot.project05.service.serviceimpl;

import com.springboot.project05.Repository.Bookrepo;
import com.springboot.project05.models.Book;
import com.springboot.project05.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class booksimpl implements bookservice {


    @Autowired
    private Bookrepo bookrepo;

    @Override
    public String Add_book(Book book) {
        return bookrepo.save(book).toString();
    }
    @Override
    public List<Book> Get_all_books() {
        return bookrepo.findAll();
    }

    @Override
    public Book Get_book_by_ID(Long bid) {
        Optional<Book> book1 = bookrepo.findById(bid);
        if (book1.isPresent()){
            return book1.get();
        }else {
            return new Book();
        }
    }

    @Override
    public String Update_book_By_Id(Long bid, Book book) {
        Optional<Book> book1 = bookrepo.findById(bid);
        if (book1.isPresent()){
            book.setBid(bid);
            bookrepo.save(book);
            return "updated";
        }else {
            return "there is no book of given id";
        }
    }

    @Override
    public String Delete_book_By_Id(Long bid) {
        if (bookrepo.findById(bid).isPresent()){
            bookrepo.deleteById(bid);
            return "deleted successfully";
        }else {
            return "there is no book of given id";
        }
    }

    @Override
    public Book Search_by_title(String title) {
       return bookrepo.findByTitle(title);
    }

    @Override
    public Book Search_by_Author(String author) {
        return bookrepo.findByAuthor(author);
    }

    @Override
    public long Count_books() {
        return bookrepo.count();
    }

    @Override
    public List<Book> Sort_by_price() {
        return null;
    }

    @Override
    public String Bulk_add(List<Book> Books) {
        return "";
    }

    @Override
    public String Delete_all_Books() {
        return "";
    }
}
