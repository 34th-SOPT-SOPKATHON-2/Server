package sopt.hackerthon.hackerthon.common.exception;

import sopt.hackerthon.hackerthon.common.status.ErrorStatus;

public class NotFoundException extends BusinessException {

  public NotFoundException(ErrorStatus errorStatus) {
    super(errorStatus);
  }
}
