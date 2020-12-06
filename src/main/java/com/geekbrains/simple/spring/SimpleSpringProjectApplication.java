package com.geekbrains.simple.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringProjectApplication.class, args);
	}

	// Домашнее задание:
	// 1. Обработать запрос вида: GET /products/filtered?min_price=100
	// В результате должен вернуться список товаров, цена которых >= 100
	// 2. Обработать запрос вида: GET /products/delete/1
	// В результате должен удалиться товар с соответствющим id
	// 3. * Попробуйте реализовать возможность изменения названия товара по id
	// Что-то вроде: /products/{id}/change_title...

}
