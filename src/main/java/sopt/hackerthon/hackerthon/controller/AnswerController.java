package sopt.hackerthon.hackerthon.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import sopt.hackerthon.hackerthon.service.dto.response.AnswerListResponse;
import sopt.hackerthon.hackerthon.service.dto.response.AnswerMessageResponse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "답변" , description = "답변 관련 기능을 담당합니다.")
public class AnswerController {

  private final AnswerMessageService answerMessageService;

  @GetMapping("/answer/list")
  @Operation(summary = "답변을 조회합니다. ", description = "상수로 저장된 답변 리스트를 반환합니다.")
  @ApiResponse(
      responseCode = "200",
      description = "정상 조회",
      content = @Content(
          schema = @Schema(implementation = AnswerListResponse.class)))
  public ResponseEntity<?> getAnswerList() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            ControllerMessage.of(SuccessStatus.STATUS_OK, answerMessageService.queryAnswerList()));
  }

  @PostMapping("/answer")
  @Operation(summary = "답변을 추가합니다. ", description = "답변을 추가합니다 ( Option ).")
  @ApiResponse(
      responseCode = "201",
      description = "답변 정상 추가",
      content = @Content(
          schema = @Schema(implementation = AnswerMessageResponse.class)))
  public ResponseEntity<?> postAnswerList(
      @RequestParam long chatId,
      @RequestBody Answer answer
  ) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ControllerMessage.of(SuccessStatus.STATUS_CREATED,
            answerMessageService.createAnswer(chatId, answer)));
  }

}
