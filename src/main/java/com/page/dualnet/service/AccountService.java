package com.page.dualnet.service;

import com.page.dualnet.model.Account;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final Path dataFile = Paths.get("data", "accounts.txt");

    public AccountService() {
        try {
            Path dir = dataFile.getParent();
            if (dir != null && !Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to initialize accounts data file", e);
        }
    }

    public synchronized void save(Account account) {
        String line = account.toString() + System.lineSeparator();
        try {
            Files.write(dataFile, line.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write account to file", e);
        }
    }

    // Read all accounts from the file
    public synchronized List<Account> readAll() {
        List<Account> out = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(dataFile);
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;
                Account a = parseLine(line);
                if (a != null) out.add(a);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read accounts file", e);
        }
        return out;
    }

    public synchronized boolean existsByUsernameOrEmail(String username, String email) {
        if (username != null) username = username.trim();
        if (email != null) email = email.trim();
        for (Account a : readAll()) {
            if (username != null && !username.isEmpty() && username.equalsIgnoreCase(a.getUsername())) return true;
            if (email != null && !email.isEmpty() && email.equalsIgnoreCase(a.getEmail())) return true;
        }
        return false;
    }

    public synchronized Optional<Account> findByUsernameOrEmail(String usernameOrEmail) {
        if (usernameOrEmail == null) return Optional.empty();
        String key = usernameOrEmail.trim();
        for (Account a : readAll()) {
            if (key.equalsIgnoreCase(a.getUsername()) || key.equalsIgnoreCase(a.getEmail())) {
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }

    public synchronized boolean validateCredentials(String usernameOrEmail, String password) {
        Optional<Account> oa = findByUsernameOrEmail(usernameOrEmail);
        if (oa.isEmpty()) return false;
        Account a = oa.get();
        String pw = a.getPassword() == null ? "" : a.getPassword();
        return pw.equals(password == null ? "" : password);
    }

    // helpers to parse the CSV-like escaped format used by Account#toString
    private Account parseLine(String line) {
        List<String> parts = splitEscaped(line);
        String u = parts.size() > 0 ? unescape(parts.get(0)) : "";
        String e = parts.size() > 1 ? unescape(parts.get(1)) : "";
        String p = parts.size() > 2 ? unescape(parts.get(2)) : "";
        return new Account(u, e, p);
    }

    private List<String> splitEscaped(String s) {
        List<String> parts = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ',') {
                // count preceding backslashes
                int backslashes = 0;
                int j = i - 1;
                while (j >= 0 && s.charAt(j) == '\\') {
                    backslashes++;
                    j--;
                }
                if (backslashes % 2 == 0) {
                    // comma is a separator
                    parts.add(cur.toString());
                    cur.setLength(0);
                    continue;
                }
            }
            cur.append(c);
        }
        parts.add(cur.toString());
        return parts;
    }

    private String unescape(String s) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < s.length()) {
                char n = s.charAt(i + 1);
                if (n == 'n') {
                    out.append('\n');
                } else if (n == ',') {
                    out.append(',');
                } else if (n == '\\') {
                    out.append('\\');
                } else {
                    // unknown escape, keep next char as-is
                    out.append(n);
                }
                i++; // skip next
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }
}
