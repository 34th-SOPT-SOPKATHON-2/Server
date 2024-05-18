package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackerthon.hackerthon.common.dto.response.ControllerMessage;
import sopt.hackerthon.hackerthon.common.status.SuccessStatus;
import sopt.hackerthon.hackerthon.service.ChatCreateService;
import sopt.hackerthon.hackerthon.service.ChatService;
import sopt.hackerthon.hackerthon.service.dto.response.ChatResponse;
import sopt.hackerthon.hackerthon.service.dto.response.ChatUserZeroCount;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "채팅" , description = "채팅 관련 기능을 담당합니다.")
public class ChatController {

  private ChatService chatService;
  private ChatCreateService chatCreateService;

  @PostMapping("/chat")
  @Operation(summary = "채팅방을 생성합니다. ", description = "member ID, friend Id를 이용해 채팅방을 생성합니다.")
  @Parameters({
      @Parameter(name = "memberId", description = "멤버의 ID, request header"),
      @Parameter(name = "friendId", description = "친구의 ID, request param"),
  })
  @ApiResponse(
      responseCode = "201",
      description = "채팅방 생성 성공",
      content = @Content(
          schema = @Schema(implementation = ChatResponse.class)))
  public ResponseEntity<?> postChat(
      @RequestHeader long memberId,
      @RequestParam long friendId
  ){
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ControllerMessage.of(SuccessStatus.STATUS_OK,chatCreateService.CreateChatRoom(memberId,friendId)));
  }

  @DeleteMapping("/chat")
  @Operation(summary = "채팅방을 삭제합니다. ", description = "chatId를 이용해 채팅방을 삭제합니다. member와 friend의 Zero Count를 1 증가시킵니다.")
  @Parameter(name = "chatId", description = "채팅방 ID, request param")
  @ApiResponse(
      responseCode = "200",
      description = "채팅방 삭제 성공",
      content = @Content(
          schema = @Schema(implementation = ChatUserZeroCount.class)))
  public ResponseEntity<?> deleteChat(
      @RequestParam long chatId
  ){
    return ResponseEntity.status(HttpStatus.OK)
        .body(ControllerMessage.of(SuccessStatus.STATUS_OK,chatService.deleteChat(chatId)));
  }

}
