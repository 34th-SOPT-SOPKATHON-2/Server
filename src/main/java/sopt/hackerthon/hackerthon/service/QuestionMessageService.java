package sopt.hackerthon.hackerthon.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.entity.QuestionMessage;
import sopt.hackerthon.hackerthon.entity.qna.Question;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.repository.QuestionMessageJpaRepository;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionListResponse;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionMessageResponse;

import sopt.hackerthon.hackerthon.entity.qna.Question;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionResponse;

@Service
@RequiredArgsConstructor
public class QuestionMessageService {

  private final ChatRepository chatRepository;
  private final ChatService chatService;
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

    Chat chat = chatService.findById(chatId);
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
}
