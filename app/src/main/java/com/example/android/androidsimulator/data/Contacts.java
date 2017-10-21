package com.example.android.androidsimulator.data;

public class Contacts {

    String name;
    int number;

    public Contacts(String contactName, int contactNumber) {
        this.name = contactName;
        this.number = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
