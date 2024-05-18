package sopt.hackerthon.hackerthon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackerthon.hackerthon.common.exception.NotFoundException;
import sopt.hackerthon.hackerthon.common.status.ErrorStatus;
import sopt.hackerthon.hackerthon.entity.Chat;
import sopt.hackerthon.hackerthon.entity.Member;
import sopt.hackerthon.hackerthon.repository.ChatRepository;
import sopt.hackerthon.hackerthon.service.dto.response.ChatResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final MemberService memberService;

    public Chat findById(long chatId) {
        return chatRepository.findById(chatId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND)
        );
    }

    public List<ChatResponse> getMyChatList(long memberId){
        Member member = memberService.findById(memberId);
        List<Chat> myChatList = chatRepository.findAllByMember(member);
        return myChatList.stream().map(
                chat -> ChatResponse.of(chat.getChatId(), chat.getMember().getId(), chat.getFriend().getId())
        ).collect(Collectors.toList());
    }

}
