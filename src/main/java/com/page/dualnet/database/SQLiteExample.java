package com.page.dualnet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/test.db"; // relativer Pfad zur Datei

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)");
                stmt.execute("INSERT INTO users (name) VALUES ('Johannes')");
                System.out.println("Datenbankverbindung erfolgreich und Daten eingefügt.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}