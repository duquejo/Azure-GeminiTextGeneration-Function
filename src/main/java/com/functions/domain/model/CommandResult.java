package com.functions.domain.model;

import java.sql.Timestamp;

public class CommandResult {
    private Timestamp timeStamp;
    private Boolean isSuccess;
    private Object message;

    public CommandResult(Boolean isSuccess, Object message) {
        this.timeStamp = new Timestamp(System.currentTimeMillis());
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommandResult{" +
            "timeStamp=" + timeStamp +
            ", isSuccess=" + isSuccess +
            ", message=" + message +
            '}';
    }
}
