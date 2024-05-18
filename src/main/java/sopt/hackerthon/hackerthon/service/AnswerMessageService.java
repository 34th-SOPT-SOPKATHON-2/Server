package sopt.hackerthon.hackerthon.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.entity.qna.Answer;
import sopt.hackerthon.hackerthon.repository.AnswerMessageJpaRepository;
import sopt.hackerthon.hackerthon.service.dto.response.AnswerListResponse;

@Service
@RequiredArgsConstructor
public class AnswerMessageService {

  private final AnswerMessageJpaRepository answerMessageJpaRepository;

  public AnswerListResponse queryAnswerList() {
    List<String> answerList = Arrays.stream(Answer.values()).map(answer -> answer.getQuestion())
        .collect(
            Collectors.toUnmodifiableList());
    return AnswerListResponse.from(answerList);
  }

}
