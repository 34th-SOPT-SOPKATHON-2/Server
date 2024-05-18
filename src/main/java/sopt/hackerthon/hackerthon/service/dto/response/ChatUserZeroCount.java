package sopt.hackerthon.hackerthon.service.dto.response;

public record ChatUserZeroCount(
    String message,
    int memberZeroCount,
    int friendZeroCount
) {
  public static ChatUserZeroCount of(String message,int memberZeroCount, int friendZeroCount) {
    return new ChatUserZeroCount(message, memberZeroCount, friendZeroCount);
  }
}
