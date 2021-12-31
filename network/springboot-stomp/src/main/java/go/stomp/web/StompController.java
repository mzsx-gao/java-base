package go.stomp.web;

import go.stomp.domain.ChatRoomRequest;
import go.stomp.domain.ChatRoomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/*
 * 在线聊天室后端实现
 */
@Controller
public class StompController {

    @Autowired
    private SimpMessagingTemplate template;/*Spring实现的一个发送模板类*/

    /*消息群发，接受发送至自massRequest的请求*/
    @MessageMapping("/massRequest")
    @SendTo("/mass/getResponse") //@SendTo可以实现处理业务后，向订阅了/mass/getResponse地址的客户端发送消息
    public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest){
        System.out.println("name = " + chatRoomRequest.getName());
        System.out.println("chatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response=new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setChatValue(chatRoomRequest.getChatValue());
        return response;
    }

    /*单独聊天，接受发送至自aloneRequest的请求*/
    @MessageMapping("/aloneRequest")
    public ChatRoomResponse alone(ChatRoomRequest chatRoomRequest){
        System.out.println("SendToUser = " + chatRoomRequest.getUserId()
                +" FromName = " + chatRoomRequest.getName()
                +" ChatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response=new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setChatValue(chatRoomRequest.getChatValue());
        //最终的访问路径类似于:/user/james/alone,其中的/user是在WebSocketConfig中设置的前缀
        this.template.convertAndSendToUser(chatRoomRequest.getUserId()+"", "/alone",response);
        return response;
    }
}