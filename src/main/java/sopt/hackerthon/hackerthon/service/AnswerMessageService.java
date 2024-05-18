package sopt.hackerthon.hackerthon.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.entity.AnswerMessage;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.entity.qna.Answer;
import sopt.hackerthon.hackerthon.repository.AnswerMessageJpaRepository;
import sopt.hackerthon.hackerthon.service.dto.response.AnswerListResponse;
import sopt.hackerthon.hackerthon.service.dto.response.AnswerMessageResponse;

@Service
@RequiredArgsConstructor
public class AnswerMessageService {

  private final AnswerMessageJpaRepository answerMessageJpaRepository;
  private final ChatService chatService;

  public AnswerListResponse queryAnswerList() {
    List<String> answerList = Arrays.stream(Answer.values()).map(Answer::getAnswer)
        .collect(Collectors.toUnmodifiableList());
    return AnswerListResponse.from(answerList);
  }

  public AnswerMessageResponse createAnswer(long chatId,
      Answer answerRequest) {

    Chat chat = chatService.findById(chatId);
    Member member = chat.getMember();
    AnswerMessage answerMessage = answerMessageJpaRepository.save(AnswerMessage.builder()
        .chat(chat)
        .answer(answerRequest)
        .friend(chat.getFriend())
        .member(member)
        .build());
    return AnswerMessageResponse.of(answerMessage.getId(), chat.getChatId(), member.getId(),
        chat.getFriend().getId());
  }

}
