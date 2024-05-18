package sopt.hackerthon.hackerthon.service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatResponse<T>(

    Long chatId,
    Long memberId,
    Long friendId,
    String friendName,
    String friendImgUrl,
    Optional<T> data
) {

  public static <T>ChatResponse of(Long chatId, Long memberId, Long friendId,String friendName, String friendImgUrl, T data) {
    return new ChatResponse(chatId, memberId, friendId, friendName, friendImgUrl,Optional.of(data));
  }

  public  static <T> ChatResponse<T> of(Long chatId, Long memberId, Long friendId,String friendName, String friendImgUrl) {
    return new ChatResponse(chatId, memberId, friendId, friendName, friendImgUrl, Optional.empty());
  }
}
