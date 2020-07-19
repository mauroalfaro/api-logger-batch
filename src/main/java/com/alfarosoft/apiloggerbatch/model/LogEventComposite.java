package com.alfarosoft.apiloggerbatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "LogEvent")
public class LogEventComposite {
    @JsonProperty("logId")
    @Id
    @Column(name = "logId")
    private String logId;

    @JsonProperty("timestamp")
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @JsonProperty("version")
    @Column(name = "version")
    private Integer version;

    @JsonProperty("message")
    @Column(name = "message")
    private String message;

    @JsonProperty("loggerName")
    @Column(name = "loggerName")
    private String loggerName;

    @JsonProperty("threadName")
    @Column(name = "threadName")
    private String threadName;

    @JsonProperty("level")
    @Column(name = "level")
    private String level;

    @JsonProperty("levelValue")
    @Column(name = "levelValue")
    private Long levelValue;

    @JsonProperty("importedData")
    @Column(name = "importedData")
    private Timestamp importedDate;

    @JsonProperty("runBatchId")
    @Column(name = "runBatchId")
    private Integer runBatchId;

    public LogEventComposite() {}

    public LogEventComposite(String logId, Timestamp timestamp, Integer version, String message, String loggerName, String threadName, String level, Long levelValue, Timestamp importedDate, Integer runBatchId) {
        this.logId = logId;
        this.timestamp = timestamp;
        this.version = version;
        this.message = message;
        this.loggerName = loggerName;
        this.threadName = threadName;
        this.level = level;
        this.levelValue = levelValue;
        this.importedDate = importedDate;
        this.runBatchId = runBatchId;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(Long levelValue) {
        this.levelValue = levelValue;
    }

    public Timestamp getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(Timestamp importedDate) {
        this.importedDate = importedDate;
    }

    public Integer getRunBatchId() {
        return runBatchId;
    }

    public void setRunBatchId(Integer runBatchId) {
        this.runBatchId = runBatchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEventComposite that = (LogEventComposite) o;
        return Objects.equals(logId, that.logId) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(version, that.version) &&
                Objects.equals(message, that.message) &&
                Objects.equals(loggerName, that.loggerName) &&
                Objects.equals(threadName, that.threadName) &&
                Objects.equals(level, that.level) &&
                Objects.equals(levelValue, that.levelValue) &&
                Objects.equals(importedDate, that.importedDate) &&
                Objects.equals(runBatchId, that.runBatchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, timestamp, version, message, loggerName, threadName, level, levelValue, importedDate, runBatchId);
    }

    @Override
    public String toString() {
        return "LogEventComposite{" +
                "logId='" + logId + '\'' +
                ", timestamp=" + timestamp +
                ", version=" + version +
                ", message='" + message + '\'' +
                ", loggerName='" + loggerName + '\'' +
                ", threadName='" + threadName + '\'' +
                ", level='" + level + '\'' +
                ", levelValue=" + levelValue +
                ", importedDate=" + importedDate +
                ", runBatchId=" + runBatchId +
                '}';
    }
}
