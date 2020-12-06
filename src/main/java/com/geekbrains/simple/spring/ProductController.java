package com.geekbrains.simple.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// http://localhost:8080/app/products
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 1. Обработать запрос вида: GET /products/filtered?min_price=100
    @GetMapping("/filtered")
    public List<Product> getFilteredByPriceProducts(@RequestParam int min_price){
        return productRepository.findAllByPriceGreaterThan(min_price);
    }

    // 2. Обработать запрос вида: GET /products/delete/1
    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    // 3. * Попробуйте реализовать возможность изменения названия товара по id
    // Что-то вроде: /products/{id}/change_title...
    @GetMapping("/{id}/change_title")
    public Product changeTitleById(@RequestParam String title, @PathVariable Long id){
        Product p = productRepository.findById(id).get();
        p.setTitle(title);
        productRepository.save(p);
        //так не сработало
        //productRepository.changeTitleById(title,id);
        return productRepository.findById(id).get();
    }

}
