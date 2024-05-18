package sopt.hackerthon.hackerthon.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.service.dto.response.ChatResponse;
import sopt.hackerthon.hackerthon.service.dto.response.ChatUserZeroCount;

@Service
@RequiredArgsConstructor
public class ChatService {

  private final ChatRepository chatRepository;
  private final MemberService memberService;
  private final FriendService friendService;

  public Chat findById(long chatId) {
    return chatRepository.findById(chatId).orElseThrow(
        () -> new NotFoundException(ErrorStatus.NOT_FOUND)
    );
  }

  @Transactional
  public ChatUserZeroCount deleteChat(long chatId){

    Chat chat = findById(chatId);
    Member member = chat.getMember();
    Friend friend = chat.getFriend();
    int memberZeroCount = memberService.increaseCount(member.getId());
    int friendZeroCount = memberService.increaseCount(member.getId());
    chatRepository.delete(chat);
    return ChatUserZeroCount.of(memberZeroCount,friendZeroCount);
  }

  public List<ChatResponse> getMyChatList(long memberId){
    Member member = memberService.findById(memberId);
    List<Chat> myChatList = chatRepository.findAllByMember(member);
    return myChatList.stream().map(
        chat -> ChatResponse.of(chat.getChatId(), chat.getMember().getId(), chat.getFriend().getId())
    ).collect(Collectors.toList());
  }

}
