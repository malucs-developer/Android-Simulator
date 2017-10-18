package com.example.android.androidsimulator.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.androidsimulator.data.Messages;
import com.example.android.androidsimulator.adapters.MessagesAdapter;
import com.example.android.androidsimulator.R;

import java.util.ArrayList;

public class MessagesActivity extends AppCompatActivity {

    ArrayList<Messages> messages;
    MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        showListMessages();
    }

    private void showListMessages() {
        messages = new ArrayList<>();
        messages.add(new Messages("Malucs", "Olá people, tudo?", "18/10"));
        messages.add(new Messages("Developer", "Vem ter comigo", "18/10"));
        messages.add(new Messages("Developer", "Vem ter comigo", "18/10"));

        addAdapter();
    }

    private void addAdapter() {
        messagesAdapter = new MessagesAdapter(this, messages);
        ListView listView = (ListView) findViewById(R.id.list_messages);
        listView.setAdapter(messagesAdapter);
    }
}
