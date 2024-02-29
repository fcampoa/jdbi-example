package org.repositories;

import org.model.Product;

import java.util.List;

public interface IProductsRepository {
    int create(Product product);
    int update(Product product);
    void delete(int id);
    List<Product> get();
    Product read(int id);
}
