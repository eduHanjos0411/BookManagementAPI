package com.dudu.BookManagement.DTO;

import com.dudu.BookManagement.model.Book;
import lombok.Builder;

@Builder
public record BookGetResponse(
        String title,
        String author,
        String isbn,
        Integer yearPublished
) {

    public static BookGetResponse fromEntity(Book book) {
        return BookGetResponse.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .yearPublished(book.getYearPublished())
                .build();
    }



}
