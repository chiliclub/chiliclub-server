package com.chiliclub.chilichat.service;

import com.chiliclub.chilichat.entity.ChatRoomEntity;
import com.chiliclub.chilichat.model.ChatRoomCreateRequest;
import com.chiliclub.chilichat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Long addChatRoom(ChatRoomCreateRequest chatRoomCreateRequest) {
        return chatRoomRepository.save(ChatRoomEntity.create(chatRoomCreateRequest)).getNo();
    }
}
