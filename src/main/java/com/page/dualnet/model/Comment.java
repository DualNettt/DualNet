package com.page.dualnet.model;
import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private int userId;
    private int postId;
    private LocalDateTime date;

    // Konstruktor ohne ID
   public Comment(String content, int userId, int postId) {
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    // Konstruktor mit ID und Datum
    public Comment(int id, String content, int userId, int postId, LocalDateTime date) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
        this.date = date;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}

