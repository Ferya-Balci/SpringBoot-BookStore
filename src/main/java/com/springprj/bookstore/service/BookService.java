package com.springprj.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springprj.bookstore.model.Book;
import com.springprj.bookstore.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public Optional<Book> findBookById(Integer bookId){
		return bookRepository.findById(bookId);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
}
