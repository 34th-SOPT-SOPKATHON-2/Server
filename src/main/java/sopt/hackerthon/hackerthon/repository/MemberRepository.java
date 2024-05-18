package sopt.hackerthon.hackerthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackerthon.hackerthon.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
