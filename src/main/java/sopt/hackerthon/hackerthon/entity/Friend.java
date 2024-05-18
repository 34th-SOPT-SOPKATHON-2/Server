package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int friendZeroCount;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String imgUrl;

    public Friend(int friendZeroCount, Member member, String imgUrl) {
        this.friendZeroCount = friendZeroCount;
        this.member = member;
        this.imgUrl = imgUrl;
    }
}
