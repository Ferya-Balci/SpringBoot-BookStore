package com.springprj.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprj.bookstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
