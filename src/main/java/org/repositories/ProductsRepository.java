package org.repositories;

import org.mappers.ProductMapper;
import org.jdbi.v3.core.Jdbi;
import org.model.Product;

import java.util.List;

public class ProductsRepository implements IProductsRepository {
    private final Jdbi jdbi;
    private final ProductMapper productMapper;
    private final String INSERT = """
            INSERT INTO Product(name,price,brand,barcode) VALUES(:name,:price,:brand,:barcode)""";
    private final String UPDATE = """
            UPDATE Product set name = :name, price = :price, brand = :price, barcode = :barcode where id = :id""";
    private final String DELETE = """
            DELETE FROM Product where id = :id""";
    private final String SELECT_ALL = """
            SELECT * FROM Product""";
    private final String SELECT = """
            SELECT * FROM Product WHERE id = :id""";
    public ProductsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
        this.productMapper = new ProductMapper();
    }
    @Override
    public int create(Product product) {
        return jdbi.withHandle(handle ->
                handle.createUpdate(INSERT)
                        .bind("name", product.name())
                        .bind("price", product.price())
                        .bind("brand", product.brand())
                        .bind("barcode", product.barcode())
                        .execute());
    }

    @Override
    public int update(Product product) {
        return jdbi.withHandle(handle ->
                handle.createUpdate(UPDATE)
                        .bind("name", product.name())
                        .bind("price", product.price())
                        .bind("brand", product.brand())
                        .bind("barcode", product.barcode())
                        .bind("id", product.id())
                        .execute());
    }

    @Override
    public void delete(int id) {
        jdbi.withHandle(handle ->
                handle.createUpdate(DELETE)
                        .bind("id", id)
                        .execute());
    }

    @Override
    public List<Product> get() {
        return jdbi.withHandle(handle ->
                handle.createQuery(SELECT_ALL)
                        .map(productMapper)
                        .list());
    }

    @Override
    public Product read(int id) {
        return jdbi.withHandle(handle ->
                handle.createQuery(SELECT_ALL)
                        .map(productMapper)
                        .first());
    }
}
