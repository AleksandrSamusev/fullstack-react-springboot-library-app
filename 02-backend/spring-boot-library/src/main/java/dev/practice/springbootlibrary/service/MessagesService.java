package dev.practice.springbootlibrary.service;

import dev.practice.springbootlibrary.dao.MessageRepository;
import dev.practice.springbootlibrary.entity.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MessagesService {

    private final MessageRepository messageRepository;

    public void postMessage(Message messageRequest, String userEmail) {
        Message message = new Message(
                messageRequest.getTitle(),
                messageRequest.getQuestion()
        );
        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }
}
