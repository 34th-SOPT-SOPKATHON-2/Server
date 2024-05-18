package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackerthon.hackerthon.common.dto.response.ControllerMessage;
import sopt.hackerthon.hackerthon.common.status.SuccessStatus;
import sopt.hackerthon.hackerthon.service.ChatService;
import sopt.hackerthon.hackerthon.service.QuestionMessageService;
import sopt.hackerthon.hackerthon.service.dto.response.ChatResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-list")
@Tag(name = "채팅" , description = "채팅 관련 기능을 담당합니다.")
public class ChatListController {

    private final ChatService chatService;
    private final QuestionMessageService questionMessageService;

    @GetMapping("/")
    @Operation(summary = "채팅방 목록 조회" , description = "member ID를 이용해 전체 채팅방을 조회합니다.")
    @Parameter(name = "memberId", description = "멤버 ID, request header")
    @ApiResponse(
        responseCode = "200",
        description = "전체 채팅방 조회 성공",
        content = @Content(
            schema = @Schema(implementation = ChatResponse.class)))
    public ResponseEntity<?> getMyChatList(@RequestHeader(name = "memberId") long memberId){
        return ResponseEntity.status(HttpStatus.OK)
            .body(ControllerMessage.of(SuccessStatus.STATUS_OK,questionMessageService.getMyChatList(memberId)));
    }
}
