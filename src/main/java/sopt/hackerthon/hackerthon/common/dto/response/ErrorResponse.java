package sopt.hackerthon.hackerthon.common.dto.response;

import sopt.hackerthon.hackerthon.common.status.ErrorStatus;

public record ErrorResponse(
    int status,
    String message

) {

  public static ErrorResponse of(int status, String message) {
    return new ErrorResponse(status, message);
  }

  public static ErrorResponse of(ErrorStatus errormessage) {
    return new ErrorResponse(errormessage.getStatus(), errormessage.getMessage());
  }
}
