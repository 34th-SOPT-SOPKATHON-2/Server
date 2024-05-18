package sopt.hackerthon.hackerthon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.hackerthon.hackerthon.service.ChatService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-list")
public class ChatListController {

    private final ChatService chatService;

    @GetMapping("/")
    public ResponseEntity<?> getMyChatList(@RequestHeader(name = "memberId") long memberId){
        return ResponseEntity.ok(chatService.getMyChatList(memberId));
    }
}
