package com.service.rest.restFul_web_service.Config;

public class HelloWorldBean {
    public HelloWorldBean(String message) {
        if(message.equals("hello")){
            this.message="how are you";
        }else if(message.equals("hi")){
            this.message = "Hi wats up";
        }else{
            this.message = "Hi ,"+message;

            //throw new RuntimeException("Runtime exception");
        }

    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
