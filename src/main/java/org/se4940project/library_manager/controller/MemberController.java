package org.se4940project.library_manager.controller;

import org.se4940project.library_manager.model.Member;
import org.se4940project.library_manager.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

        final
        MemberRepository memberRepo;

    public MemberController(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    // handle user display
        @GetMapping
        public String listMember (Model model) {
            model.addAttribute("members", memberRepo.findAll());
            model.addAttribute("newMember", new Member());
            return "members"; // Looks for books.html in templates
        }
        // handle member additions
        @PostMapping
        public String saveMember(@ModelAttribute Member member) {
            memberRepo.save(member);
            return "redirect:/members";
        }
}

