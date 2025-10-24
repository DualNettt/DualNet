package com.page.dualnet.repository;

import com.page.dualnet.model.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private static final String DB_URL = "jdbc:sqlite:database/test.db";

    // CREATE
    public void createAccount(Account account) {
        String sql = "INSERT INTO users(name, surename, email, password, biography, course) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, account.getName());
            pstmt.setString(2, account.getSurename());
            pstmt.setString(3, account.getEmail());
            pstmt.setString(4, account.getPassword());
            pstmt.setString(5, account.getBiography());
            pstmt.setString(6, account.getCourse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ by ID
    public Account getAccountById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surename"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("biography"),
                        rs.getString("course")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ all
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surename"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("biography"),
                        rs.getString("course")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // UPDATE
    public void updateAccount(Account account) {
        String sql = "UPDATE users SET name=?, surename=?, email=?, password=?, biography=?, course=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, account.getName());
            pstmt.setString(2, account.getSurename());
            pstmt.setString(3, account.getEmail());
            pstmt.setString(4, account.getPassword());
            pstmt.setString(5, account.getBiography());
            pstmt.setString(6, account.getCourse());
            pstmt.setInt(7, account.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAccount(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}