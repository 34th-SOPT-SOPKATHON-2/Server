package sopt.hackerthon.hackerthon.common.dto.response;

import java.util.Optional;
import sopt.hackerthon.hackerthon.common.status.SuccessStatus;

public record ControllerMessage<T>(

    int status,
    String message,
    Optional<T> data
) {

  public static <T>ControllerMessage<T> of(SuccessStatus successStatus){
    return new ControllerMessage(successStatus.getStatus(), successStatus.getMessage(), Optional.empty());
  }

  public  static <T>ControllerMessage<T> of(
  SuccessStatus successStatus,T data){
    return new ControllerMessage(successStatus.getStatus(), successStatus.getMessage(), Optional.of(data));
  }
}
