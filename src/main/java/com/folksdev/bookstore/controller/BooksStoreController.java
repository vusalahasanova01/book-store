package com.folksdev.bookstore.controller;

import com.folksdev.bookstore.dto.BookOrderRequest;
import com.folksdev.bookstore.model.Book;
import com.folksdev.bookstore.model.Order;
import com.folksdev.bookstore.service.BookService;
import com.folksdev.bookstore.service.OrderService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/bookstore")
public class BooksStoreController {
  private final OrderService orderService;
  private final BookService bookService;

  public BooksStoreController(OrderService orderService, BookService bookService) {

    this.orderService = orderService;
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<String> helloTwitch() {
    return ResponseEntity.ok("Hello Twitch");
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> bookList = bookService.getAllBooks();
    return ResponseEntity.ok(bookList);
  }

  @GetMapping("/orders")
  public ResponseEntity<List<Order>> getAllOrders() {
    List<Order> orderList = orderService.getAllOrders();
    return ResponseEntity.ok(orderList);
  }

  @PostMapping
  public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
    Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUsername());
    return ResponseEntity.ok(order);
  }
}
