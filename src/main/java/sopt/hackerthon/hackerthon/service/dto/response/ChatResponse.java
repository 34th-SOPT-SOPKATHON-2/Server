package sopt.hackerthon.hackerthon.service.dto.response;

public record ChatResponse(

    Long chatId,
    Long memberId,
    Long friendId
) {

  public static ChatResponse of(Long chatId, Long memberId, Long friendId) {
    return new ChatResponse(chatId, memberId, friendId);
  }
}
