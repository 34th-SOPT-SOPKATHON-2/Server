package sopt.hackerthon.hackerthon.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackerthon.hackerthon.common.dto.response.ControllerMessage;
import sopt.hackerthon.hackerthon.common.status.SuccessStatus;
import sopt.hackerthon.hackerthon.entity.qna.Answer;
import sopt.hackerthon.hackerthon.service.AnswerMessageService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AnswerController {

  private final AnswerMessageService answerMessageService;

  @GetMapping("/answer/list")
  public ResponseEntity<?> getAnswerList() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            ControllerMessage.of(SuccessStatus.STATUS_OK, answerMessageService.queryAnswerList()));
  }

  @PostMapping("/answer")
  public ResponseEntity<?> postAnswerList(
      @RequestParam long chatId,
      @RequestBody Answer answer
  ) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ControllerMessage.of(SuccessStatus.STATUS_CREATED,
            answerMessageService.createAnswer(chatId, answer)));
  }

}
