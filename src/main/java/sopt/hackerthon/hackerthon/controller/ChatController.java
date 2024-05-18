package sopt.hackerthon.hackerthon.controller;

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

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatController {

  private ChatService chatService;
  private ChatCreateService chatCreateService;

  @PostMapping("/chat")
  public ResponseEntity<?> postChat(
      @RequestHeader long memberId,
      @RequestParam long friendId
  ){
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ControllerMessage.of(SuccessStatus.STATUS_OK,chatCreateService.CreateChatRoom(memberId,friendId)));
  }

  @DeleteMapping("/chat")
  public ResponseEntity<?> deleteChat(
      @RequestParam long chatId
  ){
    return ResponseEntity.status(HttpStatus.OK)
        .body(ControllerMessage.of(SuccessStatus.STATUS_OK,chatService.deleteChat(chatId)));
  }

}
