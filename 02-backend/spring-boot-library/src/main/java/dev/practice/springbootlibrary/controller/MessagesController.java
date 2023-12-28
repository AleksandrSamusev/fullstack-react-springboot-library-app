package dev.practice.springbootlibrary.controller;

import dev.practice.springbootlibrary.entity.Message;
import dev.practice.springbootlibrary.requestModels.AdminQuestionRequest;
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
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "sub");
        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "sub");
        String admin = ExtractJWT.payloadJWTExtraction(token, "userType");
        if(admin == null || !admin.equals("admin")) {
            throw  new Exception("Administration page only.");
        }
        messagesService.putMessage(adminQuestionRequest, userEmail);
    }
}
