package com.alfarosoft.apiloggerbatch.processor;

import com.alfarosoft.apiloggerbatch.model.LogEvent;
import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import org.springframework.batch.item.ItemProcessor;

public class LogEventBatchProcessor implements ItemProcessor<LogEvent, LogEventComposite> {
    public LogEventComposite process(LogEvent logEvent) throws Exception {
        LogEventComposite logEventComposite = new LogEventComposite();

        logEventComposite.setTimestamp(logEvent.getTimestamp());
        logEventComposite.setVersion(logEvent.getVersion());
        logEventComposite.setMessage(logEvent.getMessage());
        logEventComposite.setLoggerName(logEvent.getLoggerName());
        logEventComposite.setThreadName(logEvent.getThreadName());
        logEventComposite.setLevel(logEvent.getLevel());
        logEventComposite.setLevelValue(logEvent.getLevelValue());
        return logEventComposite;
    }
}
