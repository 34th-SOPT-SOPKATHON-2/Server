package sopt.hackerthon.hackerthon.entity.qna;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Answer {

  A_1("안녕하세요 답변1 입니다."),
  A_2("안녕하세요 답변2 입니다."),
  A_3("안녕하세요 답변3 입니다."),
  A_4("안녕하세요 답변4 입니다."),
  A_5("안녕하세요 답변5 입니다."),
  A_6("안녕하세요 답변6 입니다."),
  ;
  private final String answer;
}
