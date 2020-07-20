package com.alfarosoft.apiloggerbatch.service;

import com.alfarosoft.apiloggerbatch.database.HibernateSessionFactory;
import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LogRetrievingService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session logSession;
    private static final Logger LOG = LoggerFactory.getLogger(LogRetrievingService.class);

    public LogRetrievingService(HibernateSessionFactory hibernateSessionFactory) throws Exception {
        this.hibernateSessionFactory = hibernateSessionFactory;
        this.logSession = hibernateSessionFactory.buildSession();
    }

    public List<LogEventComposite> retrieveLogs(){
        logSession.beginTransaction();
        List<LogEventComposite> logEventComposites = logSession.createQuery("from LogEventComposite", LogEventComposite.class).list();
        logSession.getTransaction().commit();
        //LOG.info("Logs imported returned");
        return logEventComposites;
    }

    public List<LogEventComposite> retrieveLogsByDate(){
        return null;
    }

    public List<LogEventComposite> retrieveLogsByLevel(String logLevel){
        logSession.beginTransaction();
        Query selectQuery = logSession.createQuery("from LogEventComposite WHERE level=:logLevel", LogEventComposite.class);
        selectQuery.setParameter("logLevel", logLevel);
        List<LogEventComposite> logEventComposites = (List<LogEventComposite>) selectQuery;
        return logEventComposites;
    }

    public List<LogEventComposite> retrieveLogsByLoggerName(String loggerName){
        logSession.beginTransaction();
        Query selectQuery = logSession.createQuery("from LogEventComposite WHERE loggerName=:loggerName", LogEventComposite.class);
        selectQuery.setParameter("loggerName", loggerName);
        List<LogEventComposite> logEventComposites = (List<LogEventComposite>) selectQuery;
        return logEventComposites;
    }

    public List<LogEventComposite> retrieveLogsByVersion(Integer version){
        logSession.beginTransaction();
        Query selectQuery = logSession.createQuery("from LogEventComposite WHERE version=:version", LogEventComposite.class);
        selectQuery.setParameter("version", version);
        List<LogEventComposite> logEventComposites = (List<LogEventComposite>) selectQuery;
        return logEventComposites;
    }

}
