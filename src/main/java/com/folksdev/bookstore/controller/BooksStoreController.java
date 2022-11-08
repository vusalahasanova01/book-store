package com.folksdev.bookstore.controller;

import com.folksdev.bookstore.dto.BookOrderRequest;
import com.folksdev.bookstore.model.Order;
import com.folksdev.bookstore.service.OrderService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/bookstore")
public class BooksStoreController {
  private final OrderService orderService;

  public BooksStoreController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public ResponseEntity<String> helloTwitch() {
    return ResponseEntity.ok("Hello Twitch");
  }

  @PostMapping
  public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
      Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUsername());
      return  ResponseEntity.ok(order);
  }
}
