package sopt.hackerthon.hackerthon.common.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessStatus {

  STATUS_OK(HttpStatus.OK.value(),"정상 출력"),;


  private final int status;
  private final String message;
}
