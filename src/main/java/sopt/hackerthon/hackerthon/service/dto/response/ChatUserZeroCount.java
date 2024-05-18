package sopt.hackerthon.hackerthon.service.dto.response;

public record ChatUserZeroCount(
    int memberZeroCount,
    int friendZeroCount
) {
  public static ChatUserZeroCount of(int memberZeroCount, int friendZeroCount) {
    return new ChatUserZeroCount(memberZeroCount, friendZeroCount);
  }
}
