package com.page.dualnet.repository;

import com.page.dualnet.model.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private static final String DB_URL = "jdbc:sqlite:database/test.db";

    // CREATE
    public void createPost(Post post) {
        String sql = "INSERT INTO post(type, image_path, content, user_id) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, post.getType());
            pstmt.setString(2, post.getImagePath());
            pstmt.setString(3, post.getContent());
            pstmt.setInt(4, post.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ by ID
    public Post getPostById(int id) {
        String sql = "SELECT * FROM post WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Post(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("image_path"),
                        rs.getString("content"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("date").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ all posts by user
    public List<Post> getPostsByUser(int userId) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM post WHERE user_id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                posts.add(new Post(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("image_path"),
                        rs.getString("content"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("date").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    // DELETE
    public void deletePost(int id) {
        String sql = "DELETE FROM post WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}