package sopt.hackerthon.hackerthon.service.dto.response;

import java.util.List;

public record QuestionListResponse(
    List<String> questionList
) {

  public static QuestionListResponse from(List<String> questionList){
    return new QuestionListResponse(questionList);
  }
}
