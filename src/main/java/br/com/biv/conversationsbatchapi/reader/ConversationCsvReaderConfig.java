package br.com.biv.conversationsbatchapi.reader;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ConversationCsvReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Conversation> csvFileReader(
            @Value("#{jobParameters['fileConversations']}") Resource fileConversations) {
        return new FlatFileItemReaderBuilder<Conversation>()
                .name("csvFileReader")
                .resource(fileConversations)
                .delimited()
                .names(new String[]{"date", "status", "message"})
                .targetType(Conversation.class)
                .build();
    }
}
