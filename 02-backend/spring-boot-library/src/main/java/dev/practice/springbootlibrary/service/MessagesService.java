package dev.practice.springbootlibrary.service;

import dev.practice.springbootlibrary.dao.MessageRepository;
import dev.practice.springbootlibrary.entity.Message;
import dev.practice.springbootlibrary.requestModels.AdminQuestionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

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

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) throws Exception {
        Optional<Message> message = messageRepository.findById(adminQuestionRequest.getId());
        if(message.isEmpty()) {
            throw  new Exception("Message not found");
        }
        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getResponse());
        message.get().setClosed(true);
        messageRepository.save(message.get());
    }

}
