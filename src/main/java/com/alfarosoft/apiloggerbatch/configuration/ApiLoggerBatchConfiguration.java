package com.alfarosoft.apiloggerbatch.configuration;

import com.alfarosoft.apiloggerbatch.database.HibernateSessionFactory;
import com.alfarosoft.apiloggerbatch.listener.ApiLoggerBatchListener;
import com.alfarosoft.apiloggerbatch.model.LogEvent;
import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import com.alfarosoft.apiloggerbatch.processor.LogEventBatchProcessor;
import com.alfarosoft.apiloggerbatch.service.LogRetrievingService;
import com.alfarosoft.apiloggerbatch.writer.LogEventBatchWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import sun.rmi.runtime.Log;

@Configuration
@EnableBatchProcessing
public class ApiLoggerBatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public HibernateSessionFactory hibernateSessionFactory(){
        return new HibernateSessionFactory();
    }

    @Bean
    public LogRetrievingService logRetrievingService() throws Exception {
        return new LogRetrievingService(hibernateSessionFactory());
    }

    @Bean
    public LogEventBatchProcessor logEventBatchProcessor() {
        return new LogEventBatchProcessor();
    }

    @Bean
    public FlatFileItemReader<LogEvent> logEventFlatFileItemReader() {
        return new FlatFileItemReaderBuilder<LogEvent>()
                .name("logEventFlatFileItemReader")
                .resource(new ClassPathResource("logs.json"))
                .delimited()
                .names("timestamp", "version", "message", "loggerName", "threadName", "level", "levelValue")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<LogEvent>() {{
                    setTargetType(LogEvent.class);
                }})
                .build();
    }

    @Bean
    public Job importLogsJob(ApiLoggerBatchListener apiLoggerBatchListener, Step logCompositeStep) {
        return jobBuilderFactory.get("importLogsJob")
                .incrementer(new RunIdIncrementer())
                .listener(apiLoggerBatchListener)
                .flow(logCompositeStep)
                .end()
                .build();
    }

    @Bean
    public LogEventBatchWriter logEventBatchWriter() throws Exception {
        return new LogEventBatchWriter(hibernateSessionFactory());
    }

    @Bean
    public Step logCompositeStep(LogEventBatchWriter writer) {
        return stepBuilderFactory.get("itemCompositeStep")
                .<LogEvent, LogEventComposite> chunk(10)
                .reader(logEventFlatFileItemReader())
                .processor(logEventBatchProcessor())
                .writer(writer)
                .build();
    }

}
