package sopt.hackerthon.hackerthon.common.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    public Friend(int friendZeroCount, Member member) {
        this.friendZeroCount = friendZeroCount;
        this.member = member;
    }
}
