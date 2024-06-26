package sopt.hackerthon.hackerthon.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalZeroCount;

    private String nickname;

    private String imgUrl;

    @Builder
    public Member(int totalZeroCount, String nickname, String imgUrl) {
        this.totalZeroCount = totalZeroCount;
        this.nickname = nickname;
        this.imgUrl = imgUrl;
    }

    public int increaseTotalZeroCount(){
        return this.totalZeroCount+=1;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}
