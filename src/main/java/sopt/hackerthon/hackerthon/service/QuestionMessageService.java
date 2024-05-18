package sopt.hackerthon.hackerthon.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.entity.QuestionMessage;
import sopt.hackerthon.hackerthon.entity.qna.Question;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.repository.QuestionMessageJpaRepository;
import sopt.hackerthon.hackerthon.service.dto.response.ChatResponse;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionListResponse;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionMessageResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionMessageService {

  private final ChatRepository chatRepository;
  private final ChatCreateService chatCreateService;
  private final QuestionMessageJpaRepository questionMessageJpaRepository;
  private final MemberService memberService;

  public QuestionListResponse queryQuestionList() {
    List<String> questionList = Arrays.stream(Question.values()).map(
            Enum::toString)
        .collect(Collectors.toUnmodifiableList());

    return QuestionListResponse.from(questionList);
  }

  public QuestionMessageResponse createQuestion(long chatId,
      Question questionRequest) {

    Chat chat = chatRepository.findById(chatId).orElseThrow(
        () -> new NotFoundException(ErrorStatus.NOT_FOUND)
    );
    Member member = chat.getMember();
    QuestionMessage questionMessage = questionMessageJpaRepository.save(QuestionMessage.builder()
        .chat(chat)
        .question(questionRequest)
        .friend(chat.getFriend())
        .member(member)
        .build());
    return QuestionMessageResponse.of(questionMessage.getId(), chat.getChatId(), member.getId(),
        chat.getFriend().getId());
  }

  public QuestionMessage findByChat(Chat chat){
    return questionMessageJpaRepository.findByChat(chat);
  }

  public List<ChatResponse> getMyChatList(long memberId){
    Member member = memberService.findById(memberId);
    List<Chat> myChatList = chatRepository.findAllByMember(member);
    return myChatList.stream().map(
        chat -> ChatResponse.of(chat.getChatId(), chat.getMember().getId(), chat.getFriend().getId(),
            chat.getFriend().getMember().getNickname(), chat.getFriend().getImgUrl())
    ).collect(Collectors.toList());
  }
}
