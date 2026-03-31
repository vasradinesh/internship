package com.springboot.project05.Repository;

import com.springboot.project05.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bookrepo extends JpaRepository<Book, Long> {
    Book findByAuthor(String author);
    Book findByTitle(String title);

}
