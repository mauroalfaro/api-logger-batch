CREATE TABLE LogEvent  (
    logId varchar(20) NOT NULL PRIMARY KEY,
    timestamp timestamp,
    version integer,
    message varchar(20),
    loggerName varchar(80),
    threadName varchar(20),
    level varchar(10),
    importedDate timestamp,
    runBatchId integer
);
