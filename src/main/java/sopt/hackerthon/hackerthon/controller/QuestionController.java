package sopt.hackerthon.hackerthon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import sopt.hackerthon.hackerthon.entity.qna.Question;
import sopt.hackerthon.hackerthon.service.QuestionMessageService;
import sopt.hackerthon.hackerthon.service.dto.response.QuestionMessageResponse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "질문",description = "사용자가 보내는 질문에 관한 부분을 담당합니다.")
public class QuestionController {

  private final QuestionMessageService questionMessageService;

  @GetMapping("/question/list")
  @Operation(summary = "질문 조회" , description = "서버에 저장된 전체 질문을 리스트로 반환합니다.")
  public ResponseEntity<?> getQuestionList(){
    return ResponseEntity.status(HttpStatus.OK)
        .body(ControllerMessage.of(SuccessStatus.STATUS_OK,questionMessageService.queryQuestionList()));
  }

  @PostMapping("/question")
  @Operation(summary = "질문 추가" , description = "chat Id와 질문을 통해 질문을 전달합니다.")
  @Parameter(name = "chatId", description = "채팅 ID, request param")
  @ApiResponse(
      responseCode = "201",
      description = "질문 추가 성공",
      content = @Content(
          schema = @Schema(implementation = QuestionMessageResponse.class)))
  public ResponseEntity<?> postQuestionList(
      @RequestParam long chatId,
      @RequestBody Question question
  ){
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ControllerMessage.of(SuccessStatus.STATUS_CREATED,questionMessageService.createQuestion(chatId, question)));
  }

}
