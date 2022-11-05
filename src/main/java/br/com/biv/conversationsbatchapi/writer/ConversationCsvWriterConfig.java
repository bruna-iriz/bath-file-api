package br.com.biv.conversationsbatchapi.writer;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversationCsvWriterConfig {

    @Bean
    public ItemWriter<Conversation> csvFileWriter() {
        return items -> items.forEach(System.out::println);
    }
}
