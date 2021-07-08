package com.example.demospringboot.services;


import com.example.demospringboot.exceptions.ResourceNotFoundException;
import com.example.demospringboot.model.Product;
import com.example.demospringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;


    @Autowired
    public void setProductRepository(ProductRepository productRepository) {this.productRepository = productRepository;}

    public List<Product> getAllProducts() {return productRepository.getProducts();}

    public Product getProduct(Long id) {

        return Optional.ofNullable(productRepository.getProduct(id)).orElseThrow(() -> new ResourceNotFoundException("Нет продукта с id:" + id));

    }

    public void addProduct(Product product) {productRepository.addProduct(product);}

    public void removeProduct(Long id) {productRepository.removeProduct(id);}

}
