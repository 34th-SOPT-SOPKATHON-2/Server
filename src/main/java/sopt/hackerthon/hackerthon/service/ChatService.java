package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.AnswerMessage;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Friend;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.entity.QuestionMessage;
import sopt.hackerthon.hackerthon.repository.AnswerMessageJpaRepository;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.repository.QuestionMessageJpaRepository;
import sopt.hackerthon.hackerthon.service.dto.response.ChatUserZeroCount;

@Service
@RequiredArgsConstructor
public class ChatService {

  private final ChatRepository chatRepository;
  private final MemberService memberService;
  private final FriendService friendService;
  private final QuestionMessageService questionMessageService;
  private final AnswerMessageJpaRepository answerMessageJpaRepository;
  private final QuestionMessageJpaRepository questionMessageJpaRepository;

//  private final ChatRepository chatRepository;
    //4 4 1 1 A_1
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
    AnswerMessage answerMessage =answerMessageJpaRepository.findByChat(chat);

    int memberZeroCount = memberService.increaseCount(member.getId());
    int friendZeroCount = memberService.increaseCount(member.getId());
    ChatUserZeroCount chatUserZeroCount = ChatUserZeroCount.of(answerMessage.getAnswer().getAnswer(),memberZeroCount,friendZeroCount);
    QuestionMessage questionmessage = questionMessageJpaRepository.findByChat(chat);
    questionMessageJpaRepository.delete(questionmessage);
    answerMessageJpaRepository.delete(answerMessage);
    chatRepository.delete(chat);
    return chatUserZeroCount;
  }


}
