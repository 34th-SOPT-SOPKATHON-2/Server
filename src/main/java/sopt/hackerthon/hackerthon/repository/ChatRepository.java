package sopt.hackerthon.hackerthon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackerthon.hackerthon.entity.Chat;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findAll(Long chatId);
}
