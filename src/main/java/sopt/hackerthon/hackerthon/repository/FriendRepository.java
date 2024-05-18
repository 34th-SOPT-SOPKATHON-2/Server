package sopt.hackerthon.hackerthon.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

    List<Friend> findAllById(Long id);

    List<Friend> findAllByMember(Member member);
}
