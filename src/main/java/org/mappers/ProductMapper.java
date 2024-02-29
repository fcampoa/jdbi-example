package org.mappers;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Product.Builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getDouble("price"))
                .brand(rs.getString("brand"))
                .barcode(rs.getString("barcode"))
                .build();
    }
}
