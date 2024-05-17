package sopt.hackerthon.hackerthon.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.hackerthon.hackerthon.common.dto.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ErrorResponse.of(e.getErrorStatus().getStatus(), e.getMessage()));
  }

}
