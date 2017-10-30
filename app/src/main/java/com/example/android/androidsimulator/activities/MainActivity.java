package com.example.android.androidsimulator.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.android.androidsimulator.R;

public class MainActivity extends AppCompatActivity {

    ImageView messagesImg;
    ImageView contactsImg;
    ImageView settingsImg;
    ImageView profileImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesImg = (ImageView) findViewById(R.id.img_messages);
        contactsImg = (ImageView) findViewById(R.id.img_contacts);
        settingsImg = (ImageView) findViewById(R.id.img_settings);
        profileImg = (ImageView) findViewById(R.id.img_profile);

        // set OnClickListener
        setEvents();
    }

    private void setEvents() {
        // messages
        messagesImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMessages = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(intentMessages);
            }
        });

        // contacts
        contactsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContacts = new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(intentContacts);
            }
        });

        // settings
        settingsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // profile
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intentProfile);
            }
        });
    }
}
