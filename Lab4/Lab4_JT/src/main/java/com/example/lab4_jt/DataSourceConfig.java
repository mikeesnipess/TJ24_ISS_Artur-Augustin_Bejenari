package com.example.lab4_jt;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.inject.Singleton;

@Singleton
@DataSourceDefinition(
        name = "jdbc/local-postgres",
        className = "org.postgresql.ds.PGSimpleDataSource",
        serverName = "localhost",
        portNumber = 5432,
        databaseName = "Lab4",
        user = "postgres",
        password = "test123"
)
public class DataSourceConfig {
    // Empty class, just used to declare the data source
}
