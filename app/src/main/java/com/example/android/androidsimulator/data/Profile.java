package com.example.android.androidsimulator.data;

public class Profile {

    private String name;
    private String age;
    private String hobbies;

    public Profile (String profileName, String profileAge, String profileHobbies) {
        this.name = profileName;
        this.age = profileAge;
        this.hobbies = profileHobbies;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHobbies() {
        return hobbies;
    }

}
