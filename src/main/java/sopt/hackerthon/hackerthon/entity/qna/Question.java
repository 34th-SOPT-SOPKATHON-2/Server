package sopt.hackerthon.hackerthon.entity.qna;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Question {

  Q_1("안녕하세요 질문1 입니다."),
  Q_2("안녕하세요 질문2 입니다."),
  Q_3("안녕하세요 질문3 입니다."),
  Q_4("안녕하세요 질문4 입니다."),
  Q_5("안녕하세요 질문5 입니다."),
  Q_6("안녕하세요 질문6 입니다."),
  ;
  @Schema(examples ={"안녕하세요 질문1 입니다.","안녕하세요 질문2 입니다.","안녕하세요 질문3 입니다.",} )
  private final String question;
}
