package com.example.android.androidsimulator.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.androidsimulator.R;
import com.example.android.androidsimulator.data.Messages;

import java.util.ArrayList;

public class SelectedMessageContact extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ArrayList<Messages> messages;
    Button sendMessageButton;
    EditText contentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_message_contact);

        contentMessage = (EditText) findViewById(R.id.message_editText);
        sendMessageButton = (Button) findViewById(R.id.sendMessage_button);
        sendMessageButton.setEnabled(false);

        // setEvents
        setEvents();


    }

    private void setEvents() {
        // enable button of sendMessage
        contentMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (contentMessage.length() > 0) {
                    sendMessageButton.setEnabled(true);
                }
                else {
                    sendMessageButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // button send message
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
     
    }
}

