package br.com.biv.conversationsbatchapi.controller;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import br.com.biv.conversationsbatchapi.service.ConversationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConversationController.class)
class ConversationControllerTest {

    @MockBean
    ConversationService conversationService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    public void shouldReturnSuccess_WhenListAllConversation() throws Exception {

        Conversation conversation = new Conversation();
        builderConversation(conversation);

        when(conversationService.listAll()).thenReturn(List.of(conversation));

        this.mockMvc
                .perform(get("/v1/conversations"))
                .andExpect(status().isOk());

        verify(conversationService, atLeastOnce()).listAll();
        assertEquals("15352", conversation.getId().toString());

    }

    @Test
    public void shouldReturnSuccess_WhenListConversationById() throws Exception {
        Conversation conversation = new Conversation();
        builderConversation(conversation);

        when(conversationService.findById(conversation.getId())).thenReturn(of(conversation));

        this.mockMvc
                .perform(get("/v1/conversations/{id}", 15352L))
                .andExpect(status().isOk());

        assertEquals("15352", conversation.getId().toString());
    }

    @Test
    public void shouldReturnSuccess_WhenDeleteConversationById() throws Exception {

        Conversation conversation = new Conversation();
        builderConversation(conversation);

        this.mockMvc
                .perform(delete("/v1/conversations/{id}", 15352L))
                .andExpect(status().isNoContent());

    }

    private void builderConversation(Conversation conversation) {
        conversation.setId(15352L);
        conversation.setData("2022-01-01");
        conversation.setStatus("Ignorado");
        conversation.setMensagem("Preciso que resolvam um problema. Estou bem chateado");
    }
}