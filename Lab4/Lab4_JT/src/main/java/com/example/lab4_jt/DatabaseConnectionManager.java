package com.example.lab4_jt;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped // Ensure this is recognized as a CDI bean
public class DatabaseConnectionManager {

    @Resource(lookup = "jdbc/jndiDataSource")
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource not initialized.");
        }
        return dataSource.getConnection();
    }
}
