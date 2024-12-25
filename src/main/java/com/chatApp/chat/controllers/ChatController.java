package com.chatApp.chat.controllers;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatApp.chat.entities.Message;
import com.chatApp.chat.entities.Room;
import com.chatApp.chat.playload.MessageRequest;
import com.chatApp.chat.repositories.RoomRepository;

import java.time.LocalDateTime;

@Controller
public class ChatController {


    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @MessageMapping("/sendMessage/{roomId}")// /app/sendMessage/roomId
    @SendTo("/topic/room/{roomId}")//subscribe
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) {

        Room room = roomRepository.findByRoomId(request.getRoomId());
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());
        if (room != null) {
            room.getMessages().add(message);
            roomRepository.save(room);
        } else {
            throw new RuntimeException("room not found !!");
        }

        return message;


    }
}