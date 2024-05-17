package sopt.hackerthon.hackerthon.common.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorStatus {

  NOT_FOUND(HttpStatus.NOT_FOUND.value(),"찾을 수 없습니다."),;

  private final int status;
  private final String message;
}
