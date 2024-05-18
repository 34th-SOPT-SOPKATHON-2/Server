package sopt.hackerthon.hackerthon.service.dto.response;

public record FriendResponseDto(
        Long id,
        int friendZeroCount,
        Long member_id,
        String nickName,
        String imgUrl

) {
    public static FriendResponseDto of(Long id, int friendZeroCount, Long memberId,String nickName, String imgUrl){
        return new FriendResponseDto(id, friendZeroCount, memberId, nickName,imgUrl);
    }
}
