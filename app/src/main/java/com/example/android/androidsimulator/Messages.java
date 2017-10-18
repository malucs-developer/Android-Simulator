package com.example.android.androidsimulator;

public class Messages {

    private String message;
    private String user;
    private String date;

    public Messages(String textMessage, String userMessage, String dateMessage) {
        this.message = textMessage;
        this.user = userMessage;
        this.date = dateMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }
}
