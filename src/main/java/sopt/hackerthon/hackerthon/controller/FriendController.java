package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
import sopt.hackerthon.hackerthon.service.FriendService;
import sopt.hackerthon.hackerthon.service.dto.response.FriendResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-list")
@Tag(name = "친구" , description = "친구 관련 기능을 담당합니다.")
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/")
    @Operation(summary = "친구 목록 조회" , description = "member ID를 이용해 모든 친구를 조회합니다.")
    @Parameter(name = "memberId", description = "멤버 ID, request header")
    @ApiResponse(
        responseCode = "200",
        description = "친구 목록 조회 성공",
        content = @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = FriendResponseDto.class))))
    public ResponseEntity<?> getMyFriendList(@RequestHeader(name = "memberId") long memberId){
        return ResponseEntity.status(HttpStatus.OK)
            .body(ControllerMessage.of(SuccessStatus.STATUS_OK,friendService.getMyFriendList(memberId)));
    }
}
