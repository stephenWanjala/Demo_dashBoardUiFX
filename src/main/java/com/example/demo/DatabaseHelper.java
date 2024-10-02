package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<Todo> getTodos() throws SQLException {
        List<Todo> todos = new ArrayList<>();
        String query = "SELECT * FROM todos ORDER BY id";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                todos.add(new Todo(
                        rs.getInt("id"),
                        rs.getString("task"),
                        rs.getBoolean("status"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }
        }
        return todos;
    }

    public static void addTodo(String task) throws SQLException {
        String query = "INSERT INTO todos (task) VALUES (?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, task);
            stmt.executeUpdate();
        }
    }

    public static void updateTodoStatus(int id, boolean status) throws SQLException {
        String query = "UPDATE todos SET status = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBoolean(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public static void deleteTodo(int id) throws SQLException {
        String query = "DELETE FROM todos WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

