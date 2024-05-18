package sopt.hackerthon.hackerthon.entity.qna;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Question {

  Q_1("나 서운해. 왜 맨날 만나는 데서만 만나?"),
  Q_2("나 서운해. 우리 약속은…"),
  Q_3("나 서운해. 우리의 약속을 소중히 여겨줘"),
  ;
  @Schema(examples ={"나 서운해. 왜 맨날 만나는 데서만 만나?","나 서운해. 우리 약속은…","나 서운해. 우리의 약속을 소중히 여겨줘",} )
  private final String question;
}
