package com.page.dualnet.controller;

import com.page.dualnet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final AccountService accountService;

    @Autowired
    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping({"/login", "/signin"})
    public String loginPage() {
        // redirect to the static login.html in resources/static
        return "redirect:/login.html";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam(required = false, name = "identifier") String identifier,
            @RequestParam(required = false) String password,
            RedirectAttributes redirectAttributes
    ) {
        String key = (identifier != null && !identifier.isBlank()) ? identifier.trim() : "";
        if (key.isEmpty() || password == null) {
            redirectAttributes.addAttribute("error", "missing");
            return "redirect:/login.html";
        }

        boolean ok = accountService.validateCredentials(key, password);
        if (!ok) {
            redirectAttributes.addAttribute("error", "invalid");
            return "redirect:/login.html";
        }

        // success -> redirect to homepage
        return "redirect:/Homepage.html";
    }
}
