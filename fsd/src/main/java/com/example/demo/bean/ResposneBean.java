package com.example.demo.bean;

public class ResposneBean {

    private Object payload;

    private String message;

    private ErrorBean errorBean;

    public ResposneBean(Object payload, String message, ErrorBean errorBean) {
        this.payload = payload;
        this.message = message;
        this.errorBean = errorBean;
    }

    public ResposneBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public ResposneBean(Object payload, String message) {
        this.payload = payload;
        this.message = message;
    }

    public ResposneBean(String message, ErrorBean errorBean) {
        this.message = message;
        this.errorBean = errorBean;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }
}
