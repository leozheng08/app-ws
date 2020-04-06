package com.appdevelopbog.app.ws.demo.ui.model.response;

public class AccountErrorMessage {
    String type = "http://cs.iit.edu/~Leo/cs445/project/api/problems/data-validation";
    String title = "Your request data didn't pass validation";
    String detail;
    String status;
    String instance;

    public AccountErrorMessage(String detail, String status,String instance) {

        this.detail = detail;
        this.status = status;
        this.instance = instance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
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
