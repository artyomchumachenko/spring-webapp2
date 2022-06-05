package com.example.springwebapp2.service;

import com.example.springwebapp2.domain.MessageEntity;
import com.example.springwebapp2.repos.MessageRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public class MessageService {
    private final MessageRepo messagesRepo;

    public MessageService(MessageRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }

    public String greetingMessage(
            Map<String, Object> model
    ) {
        return "greeting";
    }

    public String mainPage(
            Map<String, Object> model
    ) {
        Iterable<MessageEntity> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    public String addMessage(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        MessageEntity message = new MessageEntity(text, tag);
        messagesRepo.save(message);
        addAllMessagesToModel(model);
        return "main";
    }

    public String filterMessages(
            @RequestParam String filter,
            Map<String, Object> model
    ) {
        Iterable<MessageEntity> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messagesRepo.findByTag(filter);
        } else {
            messages = messagesRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }

    private void addAllMessagesToModel(Map<String, Object> model) {
        Iterable<MessageEntity> messages = messagesRepo.findAll();
        model.put("messages", messages);
    }
}
