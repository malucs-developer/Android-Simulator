package com.example.android.androidsimulator.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.androidsimulator.data.Messages;
import com.example.android.androidsimulator.adapters.MessagesAdapter;
import com.example.android.androidsimulator.R;

import java.util.ArrayList;

public class MessagesActivity extends AppCompatActivity {

    SharedPreferences preferences;

    ArrayList<Messages> messages;
    MessagesAdapter messagesAdapter;
    Button newMessage_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        newMessage_button = (Button) findViewById(R.id.newMessage_button);

        newMessage_button.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v) {
               // open the Activity SelectedMessageContact to create a new message
               Intent intent = new Intent(MessagesActivity.this, SelectedMessageContact.class);
               intent.putExtra("selectedContact", 0);
               startActivity(intent);
           }
        });

        showListMessages();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // update list
        showListMessages();
    }

    private void showListMessages() {
        messages = new ArrayList<>();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        int totalContacts = preferences.getInt("totalContacts", 0);

        for (int index = 1; index <= totalContacts; index++) {
            int totalMessages = preferences.getInt("totalMessages" + index, 0);

            if (totalMessages > 0) {
                String nameContact = preferences.getString("nameContact" + index, "");
                String lastMessage = preferences.getString("textMessage" + totalMessages + "id" + index, "");
                String dateMessage = preferences.getString("dateMessage" + totalMessages + "id" + index, "");

                messages.add(new Messages(nameContact, lastMessage, dateMessage));
            }
        }

        addAdapter();
    }

    private void addAdapter() {
        messagesAdapter = new MessagesAdapter(this, messages);
        ListView listView = (ListView) findViewById(R.id.list_messages);
        listView.setAdapter(messagesAdapter);
    }
}
