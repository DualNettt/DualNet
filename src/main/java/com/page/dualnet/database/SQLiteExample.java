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
        new SQLiteExample();
    }

    public SQLiteExample(){
        addAccounts("Johannes", "Muster", "ddd@ddd", "1234", "Das ist meine Bio");
    }
    public Statement addAccountDatabase(){
        String url = "jdbc:sqlite:database/test.db"; // relativer Pfad zur Datei

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS account (id INTEGER PRIMARY KEY, name TEXT, surename TEXT, email TEXT, password PASSWORD, bio TEXT, kurs TEXT)");
                System.out.println("Datenbank Account wurde erfolgreich hinzugefügt oder besteht bereits.");
                return stmt;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public void addAccounts(String name, String surename, String email, String password, String bio){
        Statement stmt = addAccountDatabase();
        try {
            if (stmt != null) {
                String sql = "INSERT INTO account (name, surename, email, password, bio) VALUES ('" + name + "', '" + surename + "', '" + email + "', '" + password + "', '" + bio + "')";
                stmt.execute(sql);
                System.out.println("Account wurde erfolgreich hinzugefügt.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}