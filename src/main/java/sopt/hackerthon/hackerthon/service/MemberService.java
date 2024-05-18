package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.MemberRepository;
import sopt.hackerthon.hackerthon.service.dto.response.MemberResponseDto;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(Long id){
        return memberRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorStatus.NOT_FOUND)
        );
    }

    @Transactional
    public int increaseCount(Long memberId){
        return findById(memberId).increaseTotalZeroCount();
    }

    public MemberResponseDto getMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorStatus.NOT_FOUND)
        );
        return new MemberResponseDto(
                member.getId(),
                member.getNickname(),
                member.getTotalZeroCount(),
                member.getImgUrl()
        );
    }

    @Transactional
    public String updateNickName(Long memberId, String nickName){
        Member member = findById(memberId);
        member.updateNickname(nickName);
        return member.getNickname();
    }

}
