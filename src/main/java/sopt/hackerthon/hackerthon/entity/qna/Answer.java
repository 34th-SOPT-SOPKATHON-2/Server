package sopt.hackerthon.hackerthon.entity.qna;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Answer {

  A_1("미안미안~ 다음 장소는 너 편한데서 보자!"),
  A_2("앗 서운했구나ㅠㅠ 맞아 반성 중이야ㅠㅠ"),
  A_3("혹시 서운했어? 앞으로는 그러지 않을게!"),
  ;
  private final String answer;
}
