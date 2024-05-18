package sopt.hackerthon.hackerthon.service.dto.response;

public record QuestionMessageResponse(

    Long questionId,
    Long chatId,
    Long memberId,
    Long friendId
) {
  public static QuestionMessageResponse of(Long questionId, Long chatId, Long memberId, Long friendId){
    return new QuestionMessageResponse(questionId, chatId, memberId, friendId);
  }
}
