package sopt.hackerthon.hackerthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    List<Friend> findAllByMember(Member member);
}
