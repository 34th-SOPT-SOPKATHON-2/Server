package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member findById(Long id){
        return memberRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorStatus.NOT_FOUND)
        );
    }
}
