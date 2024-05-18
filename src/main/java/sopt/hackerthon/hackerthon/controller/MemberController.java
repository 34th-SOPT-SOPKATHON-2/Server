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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackerthon.hackerthon.common.dto.response.ControllerMessage;
import sopt.hackerthon.hackerthon.common.status.SuccessStatus;
import sopt.hackerthon.hackerthon.service.MemberService;
import sopt.hackerthon.hackerthon.service.dto.response.MemberResponseDto;

@RestController
@RequestMapping("/api/v1/mypage")
@Tag(name = "멤버", description = "멤버 관련 기능을 담당합니다.")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    @Operation(summary = "멤버 정보 조회" , description = "member ID를 이용해 멤버 정보를 조회합니다.")
    @Parameter(name = "memberId", description = "멤버 ID, path variable")
    @ApiResponse(
        responseCode = "200",
        description = "멤버 조회 성공",
        content = @Content(
            schema = @Schema(implementation = MemberResponseDto.class)))
    public ResponseEntity<?> getMember(@PathVariable Long memberId){
        MemberResponseDto memberResponseDto = memberService.getMember(memberId);
        return ResponseEntity.status(HttpStatus.OK)
            .body(ControllerMessage.of(SuccessStatus.STATUS_OK,memberResponseDto));
    }

    @PutMapping("/{memberId}")
    @Operation(summary = "멤버 닉네임 변경 조회" , description = "member ID와 변경할 닉네임을 이용해 멤버 정보를 조회합니다.")
    @Parameters({
        @Parameter(name = "memberId", description = "멤버 ID, path variable"),
        @Parameter(name = "nickName", description = "변경이름 String, Request Body")
    }
    )
    @ApiResponse(
        responseCode = "200",
        description = "멤버 닉네임 변경 성공",
        content = @Content(
            schema = @Schema(implementation = String.class)))
    public ResponseEntity<?> getMember(
        @PathVariable Long memberId,
        @RequestBody String nickName
    ){
        return ResponseEntity.status(HttpStatus.OK)
            .body(ControllerMessage.of(SuccessStatus.STATUS_OK,memberService.updateNickName(memberId,nickName)));
    }
}
