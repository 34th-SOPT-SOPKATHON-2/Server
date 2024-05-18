package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.FriendRepository;
import sopt.hackerthon.hackerthon.repository.MemberRepository;
import sopt.hackerthon.hackerthon.service.dto.response.FriendResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    private final MemberService memberService;

    public Friend findById(Long id){
        return friendRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorStatus.NOT_FOUND)
        );
    }

    public List<FriendResponseDto> getMyFriendList(long memberId){
        Member member = memberService.findById(memberId);
        List<Friend> myFriendList = friendRepository.findAllByMember(member);
        return myFriendList.stream().map(
                friend -> FriendResponseDto.of(friend.getId(), friend.getFriendZeroCount(),
                        friend.getMember().getId(), friend.getImgUrl())
        ).collect(Collectors.toList());
    }

}
