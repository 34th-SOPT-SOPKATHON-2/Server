package sopt.hackerthon.hackerthon.controller;

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
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/")
    public ResponseEntity<?> getMyFriendList(@RequestHeader(name = "memberId") long memberId){
        return ResponseEntity.ok(friendService.getMyFriendList(memberId));
    }
}
