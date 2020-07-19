package com.alfarosoft.apiloggerbatch.model;

import java.sql.Timestamp;
import java.util.Objects;

public class LogEvent {
    private Timestamp timestamp;
    private Integer version;
    private String message;
    private String loggerName;
    private String threadName;
    private String level;
    private Long levelValue;

    public LogEvent(){}

    public LogEvent(Timestamp timestamp, Integer version, String message, String loggerName, String threadName, String level, Long levelValue) {
        this.timestamp = timestamp;
        this.version = version;
        this.message = message;
        this.loggerName = loggerName;
        this.threadName = threadName;
        this.level = level;
        this.levelValue = levelValue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEvent logEvent = (LogEvent) o;
        return  Objects.equals(timestamp, logEvent.timestamp) &&
                Objects.equals(version, logEvent.version) &&
                Objects.equals(message, logEvent.message) &&
                Objects.equals(loggerName, logEvent.loggerName) &&
                Objects.equals(threadName, logEvent.threadName) &&
                Objects.equals(level, logEvent.level) &&
                Objects.equals(levelValue, logEvent.levelValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, version, message, loggerName, threadName, level, levelValue);
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "timestamp=" + timestamp +
                ", version=" + version +
                ", message='" + message + '\'' +
                ", loggerName='" + loggerName + '\'' +
                ", threadName='" + threadName + '\'' +
                ", level='" + level + '\'' +
                ", levelValue=" + levelValue +
                '}';
    }

}
