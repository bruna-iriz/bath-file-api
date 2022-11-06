package br.com.biv.conversationsbatchapi.reader;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ConversationCsvReaderConfig {

    @Bean
    public JdbcPagingItemReader<Conversation> jdbcFileReader(
            @Qualifier("appDataSource") DataSource dataSource,
            PagingQueryProvider queryProvider
    ) {
        return new JdbcPagingItemReaderBuilder<Conversation>()
                .name("csvFileReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .rowMapper(new BeanPropertyRowMapper<Conversation>(Conversation.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from conversation");
        queryProvider.setSortKey("id");
        return queryProvider;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Conversation> csvFileReader(
            @Value("#{jobParameters['fileConversations']}") Resource fileConversations) {
        return new FlatFileItemReaderBuilder<Conversation>()
                .name("csvFileReader")
                .resource(fileConversations)
                .delimited()
                .names(new String[]{"data", "status", "message"})
                .targetType(Conversation.class)
                .build();
    }
}
