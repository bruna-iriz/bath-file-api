package br.com.biv.conversationsbatchapi.controller;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import br.com.biv.conversationsbatchapi.service.ConversationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@WebMvcTest(ConversationController.class)
class ConversationControllerTest {

    @MockBean
    ConversationService conversationService;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    public void shouldReturnSuccess_WhenListAllConversation() throws Exception {

        final Conversation conversation = Conversation
                .builder()
                .data("2022-01-01")
                .id(15352L)
                .status("Ignorado")
                .mensagem("Preciso que resolvam um problema. Estou bem chateado.")
                .build();

        when(conversationService.listAll())
                .thenReturn(List.of(conversation));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/conversations"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        assertEquals("15352", conversation.getId().toString());

    }

    @Test
    public void shouldReturnSuccess_WhenListConversationById() throws Exception {
        final Conversation conversation = Conversation
                .builder()
                .data("2022-01-01")
                .id(15352L)
                .status("Ignorado")
                .mensagem("Preciso que resolvam um problema. Estou bem chateado.")
                .build();

        when(conversationService.findById(conversation.getId()))
                .thenReturn(Optional.of(conversation));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/conversations/{id}", 15352L))
                .andExpect(MockMvcResultMatchers.status().isOk());

        assertEquals("15352", conversation.getId().toString());
    }

    @Test
    public void shouldReturnSuccess_WhenDeleteConversationById() throws Exception {

        final Conversation conversation = Conversation
                .builder()
                .data("2022-01-01")
                .id(15352L)
                .status("Ignorado")
                .mensagem("Preciso que resolvam um problema. Estou bem chateado.")
                .build();

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/v1/conversations/{id}", 15352L))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }
}