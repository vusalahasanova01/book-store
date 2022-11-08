package com.folksdev.bookstore.service;

import com.folksdev.bookstore.model.Book;
import com.folksdev.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private final BookRepository bookRepo;

  public BookService(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public Optional<Book> findById(Integer bookId) {
    return bookRepo.findById(bookId);
  }

  public List<Book> getAllBooks() {
    return bookRepo.findAll();
  }
}
