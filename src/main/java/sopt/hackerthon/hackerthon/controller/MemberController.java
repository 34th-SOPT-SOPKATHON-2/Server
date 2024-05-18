package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long memberId){
        MemberResponseDto memberResponseDto = memberService.getMember(memberId);
        return ResponseEntity.ok(memberResponseDto);
    }
}
