package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
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
