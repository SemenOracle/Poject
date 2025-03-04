package org.example.database;

import org.postgresql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/distributors";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gleb2004";

    public static Connection connect() throws SQLException {
        Connection connection;
        try {
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            System.out.println("Соединение с базой данных установлено!");
            return connection;
        }

        catch (SQLException e){
            throw new SQLException(e);
        }
    }
}
