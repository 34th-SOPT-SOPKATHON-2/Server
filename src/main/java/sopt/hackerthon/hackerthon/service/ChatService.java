package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.ChatRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

  private final ChatRepository chatRepository;
  private final MemberService memberService;

  public Chat findById(long chatId) {
    return chatRepository.findById(chatId).orElseThrow(
        () -> new NotFoundException(ErrorStatus.NOT_FOUND)
    );
  }

  @Transactional
  public int deleteChat(long chatId){

    Chat chat = findById(chatId);
    Member member = chat.getMember();
    Friend friend = chat.getFriend();
    int memberZeroCount = memberService.increaseCount(member.getId());
//    int friendZeroCount = memberService.increaseCount(member.getId());
    chatRepository.delete(chat);
    return memberZeroCount;
  }


}
