package br.com.biv.conversationsbatchapi.controller;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import br.com.biv.conversationsbatchapi.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
@RequestMapping("/v1/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public String loadRecords() {
        return conversationService.batchExecute().toString();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Conversation> findAll() {
        return conversationService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Conversation> findById(@RequestParam(value = "id", required = false) Long id) {
        return conversationService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam(value = "id", required = false) Long id) {
        conversationService.deleteById(id);
    }
}
