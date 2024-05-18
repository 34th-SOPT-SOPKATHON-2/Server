package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Friend friend;

    @Builder
    public Chat(Member member, Friend friend) {
        this.member = member;
        this.friend = friend;
    }
}
