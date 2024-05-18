package sopt.hackerthon.hackerthon.controller;

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
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long memberId){
        MemberResponseDto memberResponseDto = memberService.getMember(memberId);
        return ResponseEntity.ok(memberResponseDto);
    }
}
