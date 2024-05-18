package sopt.hackerthon.hackerthon.common.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalZeroCount;

    private String nickname;

    @Builder
    public Member(int totalZeroCount, String nickname) {
        this.totalZeroCount = totalZeroCount;
        this.nickname = nickname;
    }
}
