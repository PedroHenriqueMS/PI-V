package br.com.creativesystem.projetointegradorv.error;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiError.
 */
public class ApiError {
    
    /** The status. */
    private int status;
    
    /** The message. */
    private String message;
    
    /** The path. */
    private String path;
    
    /** The timestamp. */
    private long timestamp;

    /**
     * Instantiates a new api error.
     *
     * @param status the status
     * @param message the message
     * @param path the path
     */
    public ApiError(int status, String message,
                    String path) {
        this.status = status;
        this.message = message;
        this.path = path;

        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant timestampInstant = currentDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.timestamp =  timestampInstant.toEpochMilli();
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }
    
    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }
    
    /**
     * Sets the timestamp.
     *
     * @param timestamp the new timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
