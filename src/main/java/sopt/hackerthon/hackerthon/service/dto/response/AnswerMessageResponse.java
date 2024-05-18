package sopt.hackerthon.hackerthon.service.dto.response;

public record AnswerMessageResponse(

    Long answerId,
    Long chatId,
    Long memberId,
    Long friendId
) {
  public static AnswerMessageResponse of(Long answerId, Long chatId, Long memberId, Long friendId){
    return new AnswerMessageResponse(answerId, chatId, memberId, friendId);
  }
}
