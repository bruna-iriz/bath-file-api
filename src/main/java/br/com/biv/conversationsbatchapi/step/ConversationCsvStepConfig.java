package br.com.biv.conversationsbatchapi.step;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversationCsvStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step csvFileStep(ItemReader<Conversation> csvFileReader,
                            ItemWriter<Conversation> csvFileWriter) {
        return stepBuilderFactory
                .get("csvFileStep")
                .<Conversation, Conversation>chunk(50)
                .reader(csvFileReader)
                .writer(csvFileWriter)
                .build();
    }
}
