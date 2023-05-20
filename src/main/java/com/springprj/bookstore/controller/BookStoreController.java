package com.springprj.bookstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprj.bookstore.dto.BookOrderRequest;
import com.springprj.bookstore.model.Book;
import com.springprj.bookstore.model.Order;
import com.springprj.bookstore.service.BookService;
import com.springprj.bookstore.service.OrderService;

@RestController
@RequestMapping("v1/bookstore")
public class BookStoreController {
	
	private final OrderService orderService;
	private final BookService bookService;
	
	public BookStoreController(OrderService orderService,BookService bookService) {
		this.orderService=orderService;
		this.bookService=bookService;
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> bookList=bookService.getAllBooks();
		return ResponseEntity.ok(bookList);
		
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> orderList=orderService.getAllOrders();
		return ResponseEntity.ok(orderList);
		
	}
	
	
	@PostMapping
	public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
		Order order=orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());
		
		return ResponseEntity.ok(order);
	}
	
}
