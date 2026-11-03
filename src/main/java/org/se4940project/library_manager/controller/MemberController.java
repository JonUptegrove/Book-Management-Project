package org.se4940project.library_manager.controller;

import org.se4940project.library_manager.model.Member;
import org.se4940project.library_manager.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

        // handle user display
        @GetMapping
        public String listMember (Model model) {
            model.addAttribute("members", memberService.getMembers());
            model.addAttribute("newMember", new Member());
            return "members"; // Looks for members.html in templates
        }
        // handle member additions
        @PostMapping
        public String saveMember(@ModelAttribute Member member) {
            memberService.saveMember(member);
            return "redirect:/members";
        }
}

