package br.com.biv.conversationsbatchapi.writer;


import br.com.biv.conversationsbatchapi.domain.Conversation;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class ConversationCsvWriterConfig {

//    @Bean
//    public ItemWriter<Conversation> csvFileWriter() {
//        return items -> items.forEach(System.out::println);
//    }

    @Bean
    public JdbcBatchItemWriter<Conversation> csvFileWriter(@Qualifier("appDataSource") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Conversation>()
                .dataSource(dataSource)
                .sql("INSERT INTO conversation (data, status, mensagem) VALUES (?, ?, ?)")
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();
    }


    private ItemPreparedStatementSetter<Conversation> itemPreparedStatementSetter() {
        return new ItemPreparedStatementSetter<Conversation>() {

            @Override
            public void setValues(Conversation conversation, PreparedStatement ps) throws SQLException {
//                ps.setLong(1, conversation.getId());
                ps.setString(1, conversation.getData());
                ps.setString(2, conversation.getStatus());
                ps.setString(3, conversation.getMensagem());
            }
        };
    }
}
