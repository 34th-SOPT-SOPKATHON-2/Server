package sopt.hackerthon.hackerthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.hackerthon.hackerthon.entity.AnswerMessage;
import sopt.hackerthon.hackerthon.entity.Chat;

@Repository
public interface AnswerMessageJpaRepository extends JpaRepository <AnswerMessage, Long> {

  AnswerMessage findByChat(Chat chat);
}
