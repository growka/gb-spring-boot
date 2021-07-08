package com.example.demospringboot.repositories;

import com.example.demospringboot.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository{
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L,"Apple",100));
        products.add(new Product(2L,"Carrot",200));
        products.add(new Product(3L,"Pineapple",300));
        products.add(new Product(4L,"Strawberry",150));
        products.add(new Product(5L,"Cherry",250));
    }

    public void addProduct(Product product) {products.add(product);}

    public Product getProduct(Long id) {return products.get(Math.toIntExact(id));}

    public void removeProduct(Long id) {

        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> getProducts() {return products;}

}
