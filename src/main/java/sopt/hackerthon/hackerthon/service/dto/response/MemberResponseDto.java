package sopt.hackerthon.hackerthon.service.dto.response;

import sopt.hackerthon.hackerthon.entity.Member;

public record MemberResponseDto(
        Long id,
        String nickName,
        int totalZeroCount,
        String imgUrl

) {
    public static MemberResponseDto of(Member member){
        return new MemberResponseDto(member.getId(), member.getNickname(), member.getTotalZeroCount(), member.getImgUrl());
    }
}
