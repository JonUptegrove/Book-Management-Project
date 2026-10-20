package org.se4940project.library_manager.repository;

import org.se4940project.library_manager.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> { }
