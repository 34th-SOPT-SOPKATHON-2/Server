package sopt.hackerthon.hackerthon.common.exception;

import lombok.Getter;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;

@Getter
public class BusinessException extends RuntimeException {

  private final ErrorStatus errorStatus;

  public BusinessException(ErrorStatus errorStatus) {
    super(errorStatus.getMessage());
    this.errorStatus = errorStatus;
  }
}
