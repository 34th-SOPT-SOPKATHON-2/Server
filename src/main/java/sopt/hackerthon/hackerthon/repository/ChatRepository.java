package sopt.hackerthon.hackerthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Member;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findAllByMember(Member member);
}
