package com.chiliclub.chilichat.service;

import com.chiliclub.chilichat.common.enumeration.ErrorCode;
import com.chiliclub.chilichat.common.exception.ResourceNotFoundException;
import com.chiliclub.chilichat.entity.ChatRoomEntity;
import com.chiliclub.chilichat.model.ChatRoomCreateRequest;
import com.chiliclub.chilichat.model.ChatRoomFindResponse;
import com.chiliclub.chilichat.model.ChatRoomUpdateRequest;
import com.chiliclub.chilichat.model.ChatRoomUpdateResponse;
import com.chiliclub.chilichat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Long addChatRoom(ChatRoomCreateRequest chatRoomCreateRequest) {
        return chatRoomRepository.save(ChatRoomEntity.create(chatRoomCreateRequest)).getNo();
    }

    public List<ChatRoomFindResponse> findChatRoomList() {
        return chatRoomRepository.findAll().stream()
                .map(ChatRoomFindResponse::of).collect(Collectors.toList());
    }

    public void removeChatRoom(Long chatRoomNo) {
        chatRoomRepository.deleteById(chatRoomNo);
    }

    public ChatRoomUpdateResponse modifyChatRoom(Long chatRoomNo, ChatRoomUpdateRequest chatRoomUpdateRequest) {
        ChatRoomEntity chatroomToModify = chatRoomRepository.findById(chatRoomNo)
                .orElseThrow(() -> new ResourceNotFoundException(String.valueOf(ErrorCode.RESOURCE_NOT_FOUND)));

        chatroomToModify.update(chatRoomUpdateRequest);

        return ChatRoomUpdateResponse.of(chatroomToModify);
    }
}
