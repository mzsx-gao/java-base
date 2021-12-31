package go.stomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StompApplication {

    //项目启动后访问 http://localhost:8080/chatroom
    public static void main(String[] args) {
        SpringApplication.run(StompApplication.class, args);
    }
}
