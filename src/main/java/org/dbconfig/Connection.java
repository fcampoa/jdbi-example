package org.dbconfig;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;

public class Connection {
    private static Jdbi jdbi;
    public static Jdbi getConnection(String url, String user, String password) {
        return jdbi != null ? jdbi : (jdbi = Jdbi.create(url, user, password));
    }
    public static void registerMapper(RowMapper<?> mapper) {
        jdbi.registerRowMapper(mapper);
    }
}
