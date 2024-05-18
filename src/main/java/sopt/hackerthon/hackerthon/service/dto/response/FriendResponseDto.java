package sopt.hackerthon.hackerthon.service.dto.response;

import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;

public record FriendResponseDto(
        Long id,
        int friendZeroCount,
        Long member_id,
        String imgUrl
) {
    public static FriendResponseDto of(Friend friend){
        return new FriendResponseDto(friend.getId(), friend.getFriendZeroCount(),
                friend.getMember().getId(), friend.getImgUrl());
    }
}
