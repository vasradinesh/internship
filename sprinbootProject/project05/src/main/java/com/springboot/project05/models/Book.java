package com.springboot.project05.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
public class Book {

    @Id
    private Long bid;
    private String title;
    private String author;

}
