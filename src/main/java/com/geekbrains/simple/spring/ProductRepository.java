package com.geekbrains.simple.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.price >= ?1")
    List<Product> findAllByPriceGreaterThan(int min_price);

    @Query("select p from Product p where p.price < 50")
    List<Product> requestAllCheapProducts();

    @Query("update Product p set p.title = ?1 where p.id =?2")
    Product changeTitleById(String title,Long id);
}
