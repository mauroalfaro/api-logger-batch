package com.alfarosoft.apiloggerbatch.controller;

import com.alfarosoft.apiloggerbatch.model.ImportResponse;
import com.alfarosoft.apiloggerbatch.model.LogEventComposite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/logImport")
public class ApiLoggerBatchImportController {

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ImportResponse> triggerImport(){
        //LOG.info("Incoming logs search request from LogSearchController");
        //return ResponseEntity.status(HttpStatus.OK).body(logRetrievingService.retrieveLogs());
    }
}
