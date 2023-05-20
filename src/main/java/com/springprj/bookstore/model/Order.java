package com.springprj.bookstore.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Data
@Getter
@Setter
@Builder
@Entity(name="bookOrder")
@AllArgsConstructor
@NoArgsConstructor

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String userName;
	
	@Column
	@ElementCollection(targetClass = Integer.class)
	private List<Integer> bookIdList;
	

	private Double totalPrice;
}
