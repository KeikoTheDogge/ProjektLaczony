package com.example.projektjavafinal;
import java.sql.*;

public class DatabaseConnection {
    private final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfz",
            "root","pkbcilwl");
    private final Statement statement = connection.createStatement();

    public DatabaseConnection() throws SQLException {
    }

    public ResultSet result(String commandSQL) throws SQLException {
        return statement.executeQuery(commandSQL);
    }
    public void addUser(String commandSQL) throws SQLException {
        statement.executeUpdate(commandSQL);
    }

    public void addEmptyVisit(String commandSQL) throws SQLException {
        statement.execute(commandSQL);
    }
}
