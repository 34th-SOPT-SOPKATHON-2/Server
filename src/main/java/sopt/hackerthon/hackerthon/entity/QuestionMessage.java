package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.hackerthon.hackerthon.entity.qna.Question;

@Entity
@Getter
@NoArgsConstructor
public class QuestionMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Friend friend;

    public QuestionMessage(Chat chat, Question question) {
        this.chat = chat;
        this.question = question;
    }
}