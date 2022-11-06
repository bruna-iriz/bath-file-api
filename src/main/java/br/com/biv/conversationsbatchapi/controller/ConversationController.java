package br.com.biv.conversationsbatchapi.controller;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import br.com.biv.conversationsbatchapi.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/batch")
    public String execute() {
        return conversationService.batchExecute().toString();
    }

    @GetMapping("/conversations")
    public List<Conversation> findAll() {
        return conversationService.listAll();
    }
}
