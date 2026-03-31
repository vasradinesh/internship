package com.springboot.project05.service;

import com.springboot.project05.models.Book;

import java.util.List;

public interface bookservice {

    public String Add_book(Book book);
    public List<Book> Get_all_books();
    public Book Get_book_by_ID(Long bid);
    public String Update_book_By_Id(Long bid ,Book book);
    public String Delete_book_By_Id(Long bid);
    public Book Search_by_title(String title);
    public Book Search_by_Author(String author);
    public long Count_books();
    public List<Book> Sort_by_price();
    public String Bulk_add(List<Book> Books);
    public String Delete_all_Books();

}
