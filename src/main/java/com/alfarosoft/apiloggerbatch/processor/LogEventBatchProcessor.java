package com.alfarosoft.apiloggerbatch.processor;

import com.alfarosoft.apiloggerbatch.model.LogEvent;
import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import org.springframework.batch.item.ItemProcessor;

public class LogEventBatchProcessor implements ItemProcessor<LogEvent, LogEventComposite> {
    public LogEventComposite process(LogEvent logEvent) throws Exception {
        return null;
    }
}
