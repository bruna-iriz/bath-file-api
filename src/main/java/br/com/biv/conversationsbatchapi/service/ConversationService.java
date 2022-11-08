package br.com.biv.conversationsbatchapi.service;

import br.com.biv.conversationsbatchapi.domain.Conversation;
import br.com.biv.conversationsbatchapi.repository.ConversationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    private Job job;
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private ConversationRepository conversationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationService.class);

    public BatchStatus batchExecute() {
        Map<String, JobParameter> map = new HashMap<>();
        map.put("time", new JobParameter(System.currentTimeMillis()));

        try {
            JobExecution jobExecution = jobLauncher.run(job, new JobParameters(map));
            while (jobExecution.isRunning()) {
            }
            return jobExecution.getStatus();
        } catch (Exception e) {
            LOGGER.info("Fail job execution..." + e.getMessage());
            return BatchStatus.FAILED;
        }

    }

    public List<Conversation> listAll() {
        return conversationRepository.findAll();
    }

    public Optional<Conversation> findById(Long id) {
        return conversationRepository.findById(id);
    }

    public void deleteById(Long id) {
        conversationRepository.deleteById(id);
    }
}


