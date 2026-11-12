package org.se4940project.library_manager.service;


import org.se4940project.library_manager.model.Member;
import org.se4940project.library_manager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepo;

    // retrieve members
    public List<Member> getMembers() {
        return memberRepo.findAll();
    }

    // save or update member
    public void saveMember(Member member) {
        memberRepo.save(member);
    }

    // check login credentials
    public Member authenticate(String username, String password){
        Member member = memberRepo.findByUsername(username).orElse(null);
        if(member != null) {
            if (member.getPassword().equals(password)) {
                return member; // login successful
            }
        }
        return null; // login failed
    }
}
