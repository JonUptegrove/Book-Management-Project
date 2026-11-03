package org.se4940project.library_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
    @GetMapping("/")
    public String homePage() {
        return "index"; // looks for index.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
