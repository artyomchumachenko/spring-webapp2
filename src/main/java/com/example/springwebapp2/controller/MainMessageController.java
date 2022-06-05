package com.example.springwebapp2.controller;

import com.example.springwebapp2.domain.UserEntity;
import com.example.springwebapp2.service.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainMessageController {
    private final MessageService messageService;

    public MainMessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String greeting(
            Map<String, Object> model
    ) {
        return messageService.greetingMessage(model);
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return messageService.mainPage(model);
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal UserEntity user,
            @RequestParam String text,
            @RequestParam(name = "tag", required = false, defaultValue = "new") String tag,
            Map<String, Object> model
    ) {
        return messageService.addMessage(user, text, tag, model);
    }

    @PostMapping("/filter")
    public String filter(
            @RequestParam String filter,
            Map<String, Object> model
    ) {
        return messageService.filterMessages(filter, model);
    }
}
