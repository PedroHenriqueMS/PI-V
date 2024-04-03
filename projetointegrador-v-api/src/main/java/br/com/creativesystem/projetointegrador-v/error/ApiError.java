package br.com.creativesystem.projetointegradoriv.error;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ApiError {
    
    private int status;
    private String message;
    private String path;
    private long timestamp;

    public ApiError(int status, String message,
                    String path) {
        this.status = status;
        this.message = message;
        this.path = path;

        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant timestampInstant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.timestamp =  timestampInstant.toEpochMilli();
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    
    

}
