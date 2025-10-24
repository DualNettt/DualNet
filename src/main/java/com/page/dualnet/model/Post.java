package com.page.dualnet.model;


import java.time.LocalDateTime;

public class Post {
    private int id;
    private String type;       // TEXT oder IMAGE
    private String imagePath;  // optional
    private String content;    // optional
    private int userId;
    private LocalDateTime date;

    // Konstruktor ohne ID
    public Post(String type, String imagePath, String content, int userId) {
        this.type = type;
        this.imagePath = imagePath;
        this.content = content;
        this.userId = userId;
    }

    // Konstruktor mit ID und Datum
    public Post(int id, String type, String imagePath, String content, int userId, LocalDateTime date) {
        this.id = id;
        this.type = type;
        this.imagePath = imagePath;
        this.content = content;
        this.userId = userId;
        this.date = date;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}
