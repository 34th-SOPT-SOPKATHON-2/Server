package sopt.hackerthon.hackerthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.QuestionMessage;

@Repository
public interface QuestionMessageJpaRepository extends JpaRepository<QuestionMessage, Long> {

  QuestionMessage findByChat(Chat chat);
}
