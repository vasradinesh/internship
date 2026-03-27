package com.springboot.library_management.service.serviceImpl;

import com.springboot.library_management.Models.Book;
import com.springboot.library_management.service.serviceBook;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class serviceBookimpl implements serviceBook {

    List<Book> bookList = new ArrayList<>();



    @Override
    public String Add_book(Book book) {
        Optional<Book> first = bookList.stream().filter(s -> Objects.equals(s.getBid(), book.getBid())).findFirst();
        if (first.isPresent()){
            return "Book is already there with same book Id you enter";
        }else {
            bookList.add(book);
            return "book is added";
        }
    }

    @Override
    public List<Book> Get_all_books() {
        return bookList;
    }

    @Override
    public Book Get_book_by_ID(Long bid) {
        Optional<Book> first = bookList.stream().filter(s -> Objects.equals(s.getBid(), bid)).findFirst();
        if (first.isPresent()){
            return first.get();
        }else {
            return new Book();
        }
    }

    @Override
    public String Update_book_By_Id(Long bid, Book book) {
        Optional<Book> first = bookList.stream().filter(s -> Objects.equals(s.getBid(), bid)).findFirst();
        if(book.getTitle()==null || book.getPrice()==null || book.getAuthor()==null){
            return "please enter coreect details";
        }else {
            if (first.isPresent()){
                Book book1 = first.get();
                book1.setTitle(book.getTitle());
                book1.setAuthor(book.getAuthor());
                book1.setPrice(book.getPrice());
                return "book has been successfully updated";
            }else {
                return "there is no such book of given id " + bid;
            }
        }
    }

    @Override
    public String Delete_book_By_Id(Long bid) {
        boolean b = bookList.removeIf(s -> Objects.equals(bid, s.getBid()));
        if (b){
            return "given id " +bid+" book has been successfully deleted ";
        }else {
            return "there is no such book of given id " + bid;
        }
    }

    @Override
    public Book Search_by_title(String title) {
        Optional<Book> first = bookList.stream().filter(s -> Objects.equals(s.getTitle(), title)).findFirst();
        if (first.isPresent()){
            return first.get();
        }else {
            return new Book();
        }
    }

    @Override
    public Book Search_by_Author(String author) {
        Optional<Book> first = bookList.stream().filter(s -> Objects.equals(s.getAuthor(), author)).findFirst();
        if (first.isPresent()){
            return first.get();
        }else {
            return new Book();
        }
    }

    @Override
    public long Count_books() {
        return bookList.size();
    }

    @Override
    public List<Book> Sort_by_price() {
        return bookList.stream().sorted((b1,b2) -> b1.getPrice().compareTo(b2.getPrice())).collect(Collectors.toList());
    }

    @Override
    public String Bulk_add(List<Book> books) {
        for (Book b : books ){
            bookList.add(b);
        }
        return "books are added";
    }

    @Override
    public String Delete_all_Books() {
        bookList.clear();
        return "all books has been deleted";
    }
}
