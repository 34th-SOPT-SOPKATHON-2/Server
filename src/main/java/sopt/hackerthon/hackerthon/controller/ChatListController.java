package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.hackerthon.hackerthon.service.ChatService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-list")
@Tag(name = "채팅" , description = "채팅 관련 기능을 담당합니다.")
public class ChatListController {

    private final ChatService chatService;

    @GetMapping("/")
    @Operation(summary = "채팅방 목록 조회" , description = "member ID를 이용해 전체 채팅방을 조회합니다.")
    @Parameter(name = "memberId", description = "멤버 ID, request header")
    public ResponseEntity<?> getMyChatList(@RequestHeader(name = "memberId") long memberId){
        return ResponseEntity.ok(chatService.getMyChatList(memberId));
    }
}
