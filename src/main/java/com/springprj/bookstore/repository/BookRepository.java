package com.springprj.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprj.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
