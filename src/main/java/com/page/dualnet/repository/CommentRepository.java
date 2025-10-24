package com.page.dualnet.repository;

import com.page.dualnet.model.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    private static final String DB_URL = "jdbc:sqlite:database/test.db";

    // CREATE
    public void createComment(Comment comment) {
        String sql = "INSERT INTO comment(content, user_id, post_id) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, comment.getContent());
            pstmt.setInt(2, comment.getUserId());
            pstmt.setInt(3, comment.getPostId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ by ID
    public Comment getCommentById(int id) {
        String sql = "SELECT * FROM comment WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Comment(
                        rs.getInt("id"),
                        rs.getString("content"),
                        rs.getInt("user_id"),
                        rs.getInt("post_id"),
                        rs.getTimestamp("date").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ all comments for a post
    public List<Comment> getCommentsByPost(int postId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE post_id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("id"),
                        rs.getString("content"),
                        rs.getInt("user_id"),
                        rs.getInt("post_id"),
                        rs.getTimestamp("date").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    // DELETE
    public void deleteComment(int id) {
        String sql = "DELETE FROM comment WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}