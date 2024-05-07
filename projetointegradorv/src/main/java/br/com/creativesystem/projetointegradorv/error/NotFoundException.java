package br.com.creativesystem.projetointegradorv.error;

// TODO: Auto-generated Javadoc
/**
 * The Class NotFoundException.
 */
public class NotFoundException extends RuntimeException{
    
    /** The msg. */
    private String msg;

    /**
     * Instantiates a new not found exception.
     *
     * @param msg the msg
     */
    public NotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
    
    /**
     * Gets the msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the msg.
     *
     * @param msg the new msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
