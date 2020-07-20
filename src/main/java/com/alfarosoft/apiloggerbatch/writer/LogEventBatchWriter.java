package com.alfarosoft.apiloggerbatch.writer;

import com.alfarosoft.apiloggerbatch.database.HibernateSessionFactory;
import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import org.hibernate.Session;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Query;
import java.util.List;

public class LogEventBatchWriter implements ItemWriter<LogEventComposite> {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session logSession;

    @Value("${apiLogger.deleteLogsBeforeImport}")
    private Boolean wipeData;

    public LogEventBatchWriter(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.logSession = hibernateSessionFactory.buildSession();
    }

    public void write(List<? extends LogEventComposite> list) throws Exception {
        if(wipeData){
            wipeDbData();
        }
        for(LogEventComposite logEventComposite : list){
            logSession.beginTransaction();
            logSession.save(logEventComposite);
            logSession.getTransaction().commit();
        }
    }

    private void wipeDbData(){
        logSession.beginTransaction();
        String stringQuery = "DELETE FROM LogEventComposite";
        Query query = logSession.createQuery(stringQuery);
        query.executeUpdate();
        logSession.getTransaction().commit();
    }
}
