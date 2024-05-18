package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.service.dto.response.InitChatResponse;

@Service
@RequiredArgsConstructor
public class ChatCreateService {

  private final ChatRepository chatRepository;
  private final MemberService memberService;
  private final FriendService friendService;

  @Transactional
  public InitChatResponse CreateChatRoom(long memberId, long friendId) {

    Member member = memberService.findById(memberId);
    Friend friend = friendService.findById(friendId);
    Member receiver = memberService.findById(friend.getId());
    Chat chat = new Chat(member, friend);
    Chat saved = chatRepository.save(chat);
    return InitChatResponse.of(saved.getChatId(), member.getId(), receiver.getId(),
        receiver.getNickname(),
        receiver.getImgUrl());
  }
}
