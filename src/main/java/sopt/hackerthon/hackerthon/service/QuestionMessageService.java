package sopt.hackerthon.hackerthon.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.QuestionMessage;
import sopt.hackerthon.hackerthon.repository.QuestionMessageJpaRepository;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionListResponse;
import sopt.hackerthon.hackerthon.entity.qna.Question;

@Service
@RequiredArgsConstructor
public class QuestionMessageService {

  private final ChatRepository chatRepository;
  private final ChatCreateService chatCreateService;
  private final QuestionMessageJpaRepository questionMessageJpaRepository;

  public QuestionListResponse queryQuestionList() {
    List<String> questionList = Arrays.stream(Question.values()).map(answer ->
        answer.toString()).collect(Collectors.toUnmodifiableList());

    return QuestionListResponse.from(questionList);
  }

  public QuestionResponse createQuestion(long memberId, long chatId, Question questionRequest) {

    Chat chat = chatCreateService.findbyId(chatId);
    Member member = memberService.findById(memberId);
    QuestionMessage questionMessage = questionMessageJpaRepository.save(QuestionMessage.builder()
        .chat(chat)
        .question(questionRequest)
        .friend(chat.getFriend())
        .member(member)
        .build());
    return questionMessageResponse.of( "questionId", "chatId" , "memberId", "friendId");
  }
}
