package com.dudu.BookManagement.model;

import com.dudu.BookManagement.DTO.BookGetResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private Integer yearPublished;

    public Book(BookGetResponse data) {
        this.title = data.title();
        this.author = data.author();
        this.isbn = data.isbn();
        this.yearPublished = data.yearPublished();
    }

}
