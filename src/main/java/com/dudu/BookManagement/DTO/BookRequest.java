package com.dudu.BookManagement.DTO;

import jakarta.validation.constraints.NotBlank;

public record BookRequest(
        @NotBlank(message = "Book´s title cannot be empty")
        String title,

        @NotBlank(message = "Book´s author cannot be empty")
        String author,

        String isbn,

        Integer yearPublished
) {
}
