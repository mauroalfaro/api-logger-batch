package com.alfarosoft.apiloggerbatch.writer;

import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class LogEventBatchWriter implements ItemWriter<LogEventComposite> {
    public void write(List<? extends LogEventComposite> list) throws Exception {

    }
}
