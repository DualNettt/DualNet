package com.page.dualnet.service;

import com.page.dualnet.model.Account;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
}
