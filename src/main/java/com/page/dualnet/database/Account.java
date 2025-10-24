//Hallo MAx, das gehört hier nicht rein, aber du hast schon eine Account Klasse :)

package com.page.dualnet.database;

public class Account {
    private int id;
    private String name;
    private String surename;
    private String email;
    private String password;
    private String biography;
    private String course;

    // Konstruktor ohne ID (für Inserts)
    public Account(String name, String surename, String email, String password, String biography, String course) {
        this.name = name;
        this.surename = surename;
        this.email = email;
        this.password = password;
        this.biography = biography;
        this.course = course;
    }

    // Konstruktor mit ID (für Reads)
    public Account(int id, String name, String surename, String email, String password, String biography, String course) {
        this.id = id;
        this.name = name;
        this.surename = surename;
        this.email = email;
        this.password = password;
        this.biography = biography;
        this.course = course;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurename() { return surename; }
    public void setSurename(String surename) { this.surename = surename; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}