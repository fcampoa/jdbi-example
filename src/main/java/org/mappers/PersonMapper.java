package org.dbconfig;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Person(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("lastname"),
                rs.getString("email"),
                rs.getString("dni"));
    }
}
