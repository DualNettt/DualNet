/*Kurze Erklärung:
Hier werden die einzelnen Tables initialisiert. Es gibt 3 primäre
- accounts
- comment
- post
da comment und accounts zu sich selbst eine n zu m Beziehung haben,
sind diese über die unten zu sehenden join tables miteinander verbunden*/


package com.page.dualnet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String DB_URL = "jdbc:sqlite:database/test.db";

    public static void initialize() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            //legt Benutzer an, mit name, surename, email, password, biography, course
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    surename TEXT NOT NULL,
                    email TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    biography TEXT,
                    course TEXT
                )
            """);

            //Join table -> n zu m Beziehung von account zu account, weil sie sich gegenseitig folgen können
            /* Alle follower eines Nutzers anzeigen
            SELECT u.name
            FROM users u
            JOIN user_followers uf ON u.id = uf.follower_id
            WHERE uf.following_id = 1;
            */
            /*Anzeigen, wem ein Nutzer folgt
            SELECT u.name
            FROM users u
            JOIN user_followers uf ON u.id = uf.following_id
            WHERE uf.follower_id = 1;
            */

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS user_followers (
                    follower_id INTEGER NOT NULL,
                    following_id INTEGER NOT NULL,
                    FOREIGN KEY(follower_id) REFERENCES users(id) ON DELETE CASCADE,
                    FOREIGN KEY(following_id) REFERENCES users(id) ON DELETE CASCADE,
                    PRIMARY KEY(follower_id, following_id)
                )
            """);


            stmt.execute("""
                CREATE TABLE IF NOT EXISTS post (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    type TEXT NOT NULL,
                    image_path TEXT,
                    content TEXT,
                    user_id INTEGER NOT NULL,
                    date DATETIME DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS comment (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    content TEXT,
                    date DATETIME DEFAULT CURRENT_TIMESTAMP,
                    user_id INTEGER NOT NULL,
                    post_id INTEGER NOT NULL,
                    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
                    FOREIGN KEY(post_id) REFERENCES post(id) ON DELETE CASCADE
                )
            """);

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS comment_replies (
                    parent_comment_id INTEGER NOT NULL,
                    child_comment_id INTEGER NOT NULL,
                    FOREIGN KEY(parent_comment_id) REFERENCES comment(id) ON DELETE CASCADE,
                    FOREIGN KEY(child_comment_id) REFERENCES comment(id) ON DELETE CASCADE,
                    PRIMARY KEY(parent_comment_id, child_comment_id)
                    );
            """);

            System.out.println("Alle Tabellen erfolgreich erstellt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
