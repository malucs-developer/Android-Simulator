package com.example.android.androidsimulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView messagesImg;
    ImageView contactsImg;
    ImageView settingsImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesImg = (ImageView) findViewById(R.id.img_messages);
        contactsImg = (ImageView) findViewById(R.id.img_contacts);
        settingsImg = (ImageView) findViewById(R.id.img_settings);

        // set OnClickListener
        setEvents();
    }

    private void setEvents() {
        // messages
        messagesImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }
}
