package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackerthon.hackerthon.service.FriendService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-list")
@Tag(name = "친구" , description = "친구 관련 기능을 담당합니다.")
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/")
    @Operation(summary = "친구 목록 조회" , description = "member ID를 이용해 모든 친구를 조회합니다.")
    @Parameter(name = "memberId", description = "친구 ID, request header")
    public ResponseEntity<?> getMyFriendList(@RequestHeader(name = "memberId") long memberId){
        return ResponseEntity.ok(friendService.getMyFriendList(memberId));
    }
}
