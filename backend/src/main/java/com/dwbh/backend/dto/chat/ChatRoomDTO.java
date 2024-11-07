package com.dwbh.backend.dto.chat;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @Setter
public class ChatRoomDTO {

    private String roomId;
    private String nickName;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomDTO create(String name){
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.nickName = name;

        return room;
    }

}
