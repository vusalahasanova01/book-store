package com.folksdev.bookstore.service;

import com.folksdev.bookstore.model.Book;
import com.folksdev.bookstore.model.Order;
import com.folksdev.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
  private final BookService bookService;
  private final OrderRepository orderRepo;

  public OrderService(BookService bookService, OrderRepository orderRepo) {
    this.bookService = bookService;
    this.orderRepo = orderRepo;
  }

  public Order putAnOrder(List<Integer> bookIdList, String username) {
    List<Optional<Book>> selectedBookList = bookIdList.stream()
        .map(bookId -> bookService.findById(bookId)).collect(Collectors.toList());

    Double totalPrice = selectedBookList.stream()
        .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
        .reduce(0.0, Double::sum);

    Order order = Order.builder()
        .bookList(bookIdList)
        .totalPrice(totalPrice)
        .username(username)
        .build();
    return orderRepo.save(order);
  }

  public List<Order> getAllOrders() {
    return orderRepo.findAll();
  }


}
