package sopt.hackerthon.hackerthon.service.dto.response;

import java.util.List;
import sopt.hackerthon.hackerthon.entity.qna.Answer;

public record AnswerListResponse(
    List<String> answerList
) {

  public static AnswerListResponse from(List<String> answerList){
    return new AnswerListResponse(answerList);
  }
}
