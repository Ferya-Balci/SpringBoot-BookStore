package com.springprj.bookstore.service;

import com.springprj.bookstore.model.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springprj.bookstore.model.Order;
import com.springprj.bookstore.repository.OrderRepository;




@Service
public class OrderService {

	private final Logger logger =LoggerFactory.getLogger(OrderService.class);
	
	private final BookService bookService;
	private final OrderRepository orderRepository;
	
	
	public OrderService(BookService bookService,OrderRepository orderRepository) {
		this.bookService=bookService;
		this.orderRepository=orderRepository;
	}
	
	 public Order putAnOrder(List<Integer> bookIdList,String userName) {
	        List<Optional<Book>> bookList = bookIdList.stream()
	                .map(bookService::findBookById).collect(Collectors.toList());

	        Double totalPrice = bookList.stream()
	                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
	                .reduce(0.0, Double::sum);
	        
	        Order order=Order.builder()
	        		.bookIdList(bookIdList)
	        		.totalPrice(totalPrice)
	        		.userName(userName)
	        		.build();
	        return orderRepository.save(order);
	 }
	 
	 public List<Order> getAllOrders(){
		 return orderRepository.findAll();
	 }
	
}
