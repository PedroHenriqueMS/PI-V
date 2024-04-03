package br.com.creativesystem.projetointegradoriv.error;

public class NotFoundException extends RuntimeException{
    
    private String msg;

    public NotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
