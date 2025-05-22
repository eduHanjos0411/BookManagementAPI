package com.dudu.BookManagement.service;

import com.dudu.BookManagement.DTO.BookGetResponse;
import com.dudu.BookManagement.DTO.BookRequest;
import com.dudu.BookManagement.DTO.BookCreateResponse;
import com.dudu.BookManagement.exception.ResourceNotFoundException;
import com.dudu.BookManagement.model.Book;
import com.dudu.BookManagement.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookCreateResponse createNewBook(BookRequest newBookData) {
        Book newBook = new Book();
        newBook.setTitle(newBookData.title());
        newBook.setAuthor(newBookData.author());
        newBook.setIsbn(newBookData.isbn());
        newBook.setYearPublished(newBookData.yearPublished());

        bookRepository.save(newBook);

        return BookCreateResponse.fromEntity(newBook);
    }

    public List<BookGetResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookGetResponse::fromEntity).toList();
    }

    public BookGetResponse getBookById(Long id) {
        Book bookFound = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id" + id + " not found"));
        return BookGetResponse.fromEntity(bookFound);
    }

    public BookGetResponse updateBookById(Long id, BookRequest dataToUpdate) {
        Book bookToUpdate = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id: " + id + " not found"));

        bookToUpdate.setTitle(dataToUpdate.title());
        bookToUpdate.setAuthor(dataToUpdate.author());
        bookToUpdate.setIsbn(dataToUpdate.isbn());
        bookToUpdate.setYearPublished(dataToUpdate.yearPublished());
        bookRepository.save(bookToUpdate);

        return BookGetResponse.fromEntity(bookToUpdate);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
