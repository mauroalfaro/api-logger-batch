package com.alfarosoft.apiloggerbatch.controller;

import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import com.alfarosoft.apiloggerbatch.service.LogRetrievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/logSearch")
public class LogSearchController {

    private final LogRetrievingService logRetrievingService;
    //private static final Logger LOG = LoggerFactory.getLogger(LogSearchController.class);

    @Autowired
    public LogSearchController(LogRetrievingService logRetrievingService) {
        this.logRetrievingService = logRetrievingService;
    }

    @GetMapping(value = "/logs", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LogEventComposite>> searchAllLogs(){
        //LOG.info("Incoming logs search request from LogSearchController");
        return ResponseEntity.status(HttpStatus.OK).body(logRetrievingService.retrieveLogs());
    }

    @GetMapping(value = "/logs/byDate/{date}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LogEventComposite>> searchLogsByDate(){
        //LOG.info("Incoming logs search request from LogSearchController");
        return ResponseEntity.status(HttpStatus.OK).body(logRetrievingService.retrieveLogsByDate());
    }

    @GetMapping(value = "/logs/byLevel/{level}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LogEventComposite>> searchLogsByLevel(@PathVariable String logLevel){
        //LOG.info("Incoming logs search request from LogSearchController");
        return ResponseEntity.status(HttpStatus.OK).body(logRetrievingService.retrieveLogsByLevel(logLevel));
    }

    @GetMapping(value = "/logs/byLoggerName/{loggerName}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LogEventComposite>> searchLogsByLoggerName(@PathVariable String loggerName){
        //LOG.info("Incoming logs search request from LogSearchController");
        return ResponseEntity.status(HttpStatus.OK).body(logRetrievingService.retrieveLogsByLoggerName(loggerName));
    }

    @GetMapping(value = "/logs/byVersion/{version}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LogEventComposite>> searchLogsByVersion(@PathVariable Integer version){
        //LOG.info("Incoming logs search request from LogSearchController");
        return ResponseEntity.status(HttpStatus.OK).body(logRetrievingService.retrieveLogsByVersion(version));
    }
}
