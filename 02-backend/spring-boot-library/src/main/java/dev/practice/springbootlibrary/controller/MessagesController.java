package dev.practice.springbootlibrary.controller;

import dev.practice.springbootlibrary.entity.Message;
import dev.practice.springbootlibrary.service.MessagesService;
import dev.practice.springbootlibrary.utils.ExtractJWT;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessagesController {
    private final MessagesService messagesService;


    @PostMapping("/secure/add/message")
    public void postMessage( @RequestHeader(value = "Authorization") String token,
                             @RequestBody Message messageRequest) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token);
        messagesService.postMessage(messageRequest, userEmail);
    }
}
