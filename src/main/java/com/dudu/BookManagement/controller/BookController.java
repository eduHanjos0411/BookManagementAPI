package com.dudu.BookManagement.controller;

import com.dudu.BookManagement.DTO.BookCreateResponse;
import com.dudu.BookManagement.DTO.BookGetResponse;
import com.dudu.BookManagement.DTO.BookRequest;
import com.dudu.BookManagement.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookCreateResponse> addNewBook(@RequestBody BookRequest newBookToAdd) {
        BookCreateResponse newBook = bookService.createNewBook(newBookToAdd);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookGetResponse>> showAllBooks() {
        List<BookGetResponse> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookGetResponse> showBookById(@PathVariable Long id) {
        BookGetResponse book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookGetResponse> updateBookById(@PathVariable Long id, @RequestBody BookRequest dataToUpdate) {
        BookGetResponse bookToUpdate = bookService.updateBookById(id, dataToUpdate);
        return ResponseEntity.ok(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

}
