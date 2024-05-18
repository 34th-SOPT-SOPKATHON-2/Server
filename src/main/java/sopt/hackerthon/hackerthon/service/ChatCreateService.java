package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.service.dto.response.ChatResponse;

@Service
@RequiredArgsConstructor
public class ChatCreateService {

  private final ChatRepository chatRepository;
  private final MemberService memberService;
  private final FriendService friendService;

  @Transactional
  public ChatResponse CreateChatRoom(long memberId, long friendId){

    Member member = memberService.findById(memberId);
    Friend friend = friendService.findById(friendId);

    Chat chat = new Chat(member, friend);
    Chat saved = chatRepository.save(chat);
    return ChatResponse.of(saved.getChatId(),member.getId(), friend.getId());
  }
}
