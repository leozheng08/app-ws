package com.appdevelopbog.app.ws.demo.exceptions;

import org.springframework.http.HttpStatus;

public class AccountServiceException extends RuntimeException{
    public static final long serialVersionUID = 174108796233756193L;
    private String detail;
    private String status;
    private String instance;
    public AccountServiceException(String detail, HttpStatus status, String instance){
        this.detail = detail;
        this.status = status.toString();
        this.instance = instance;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
