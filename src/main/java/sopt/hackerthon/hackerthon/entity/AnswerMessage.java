package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.hackerthon.hackerthon.entity.qna.Answer;

@Entity
@Getter
@NoArgsConstructor
public class AnswerMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Friend friend;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Builder
    public AnswerMessage(Chat chat, Answer answer,Member member, Friend friend) {
        this.chat = chat;
        this.answer = answer;
        this.member = member;
        this.friend = friend;
    }
}
