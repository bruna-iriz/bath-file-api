package br.com.biv.conversationsbatchapi.controller;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import br.com.biv.conversationsbatchapi.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/conversations")
@EnableSwagger2
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/batch")
    public String execute() {
        return conversationService.batchExecute().toString();
    }

    @GetMapping
    public List<Conversation> findAll() {
        return conversationService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Conversation> findById(@RequestParam Long id) {
        return conversationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam Long id) {
        conversationService.deleteById(id);
    }
}
