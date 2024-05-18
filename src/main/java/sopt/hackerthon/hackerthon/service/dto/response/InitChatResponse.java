package sopt.hackerthon.hackerthon.service.dto.response;

public record InitChatResponse(
    Long chatId,
    Long memberId,
    Long friendId,
    String friendName,
    String friendImgUrl
) {
  public static InitChatResponse of(Long chatId, Long memberId, Long friendId,String friendName, String friendImgUrl) {
    return new InitChatResponse(chatId, memberId, friendId, friendName, friendImgUrl);
  }
}
