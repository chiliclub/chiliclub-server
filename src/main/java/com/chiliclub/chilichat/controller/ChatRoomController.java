package com.chiliclub.chilichat.controller;

import com.chiliclub.chilichat.model.ChatRoomCreateRequest;
import com.chiliclub.chilichat.model.ChatRoomFindResponse;
import com.chiliclub.chilichat.service.ChatRoomService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat-rooms")
@RequiredArgsConstructor
@Validated
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @ApiOperation(value = "채팅방 생성")
    @PostMapping("")
    public ResponseEntity<Long> chatRoomAdd(
            @RequestBody ChatRoomCreateRequest chatRoomCreateRequest
    ) {
        Long chatRoomId = chatRoomService.addChatRoom(chatRoomCreateRequest);

        return ResponseEntity.ok(chatRoomId);
    }

    @ApiOperation(value = "채팅방 목록 조회")
    @GetMapping("")
    public ResponseEntity<List<ChatRoomFindResponse>> chatRoomList() {
        return ResponseEntity.ok(chatRoomService.findChatRoomList());
    }
}