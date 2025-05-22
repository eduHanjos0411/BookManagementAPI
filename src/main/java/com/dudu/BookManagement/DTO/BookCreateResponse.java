package com.dudu.BookManagement.DTO;

import com.dudu.BookManagement.model.Book;
import lombok.Builder;

@Builder
public record BookCreateResponse(
        String title,
        String author) {

    public static BookCreateResponse fromEntity(Book book) {
        return BookCreateResponse.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }
}
