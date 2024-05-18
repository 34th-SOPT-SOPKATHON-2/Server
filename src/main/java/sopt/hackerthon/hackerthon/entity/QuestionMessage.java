package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
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

    @Builder
    public QuestionMessage(Chat chat, Question question, Member member, Friend friend) {
        this.chat = chat;
        this.question = question;
        this.member = member;
        this.friend = friend;
    }
}
