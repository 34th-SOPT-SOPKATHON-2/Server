package sopt.hackerthon.hackerthon.common.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class AnswerMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    private String messageContent;

    public AnswerMessage(Chat chat, String messageContent) {
        this.chat = chat;
        this.messageContent = messageContent;
    }
}
