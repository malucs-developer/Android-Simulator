package com.example.android.androidsimulator.data;

public class Messages {

    private String message;
    private String user;
    private String date;

    public Messages(String userMessage, String textMessage, String dateMessage) {
        this.user = userMessage;
        this.message = textMessage;
        this.date = dateMessage;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
