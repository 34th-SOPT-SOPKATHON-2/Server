package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.repository.FriendRepository;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    public Friend findById(Long id){
        return friendRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(ErrorStatus.NOT_FOUND)
        );
    }

}
