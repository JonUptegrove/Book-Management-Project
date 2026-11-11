package org.se4940project.library_manager.controller;

import jakarta.servlet.http.HttpSession;
import org.se4940project.library_manager.model.Member;
import org.se4940project.library_manager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Member member = memberService.authenticate(username, password);
        if (member != null) {
            session.setAttribute("loggedInUser", member); // Save user state
            return "redirect:/books";
        }
        return "redirect:/login?error=true";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clears all session attributes
        return "redirect:/books";
    }
}
