package com.example.android.androidsimulator.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.androidsimulator.R;
import com.example.android.androidsimulator.adapters.SelectedContactAdapter;
import com.example.android.androidsimulator.adapters.SelectedMessageAdapter;
import com.example.android.androidsimulator.data.Contacts;
import com.example.android.androidsimulator.data.Messages;

import java.util.ArrayList;

public class SelectedMessageContact extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    ArrayList<Contacts> contacts;
    ArrayList<Messages> messages;

    SelectedContactAdapter contactAdapter;
    SelectedMessageAdapter messagesAdapter;

    ListView listView;

    Button sendMessageButton;
    EditText contentMessage;
    int selectedContact = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_message_contact);

        // views
        listView = (ListView) findViewById(R.id.list_selected_messages);
        contentMessage = (EditText) findViewById(R.id.message_editText);
        sendMessageButton = (Button) findViewById(R.id.sendMessage_button);
        sendMessageButton.setEnabled(false);

        // storage
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // get the selected contact to view/send message
        Intent getLastIntent = getIntent();
        selectedContact = getLastIntent.getIntExtra("selectedCount", 0);

        /*
        *
        * This condition will check the selected contact
        * if the selected contact equals to zero then
        * the list of contacts appears and we need to select one to send a message
        * else if we have a selected contact then will appears the list of messages
        *
        */
        if (selectedContact == 0) {
           showContacts();
        }
        else {
           showMessages();
        }

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

    private void showContacts() {
        contacts = new ArrayList<>();

        int totalContacts = preferences.getInt("totalContacts", 0);

        String name = "";
        int number = 0;

        for (int index = 1; index <= totalContacts; index++) {
            name = preferences.getString("nameContact" + index, "");
            number = preferences.getInt("numberContact" + index, 0);

            contacts.add(new Contacts(name, number));
        }

        // adapter
        contactAdapter = new SelectedContactAdapter(this, contacts);
        listView.setAdapter(contactAdapter);

        // set OnClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get name of selected contact
                // start id of contact = 1
                setTitle(preferences.getString("nameContact" + (position + 1), ""));
            }
        });
    }

    private void showMessages() {
        messages = new ArrayList<>();
        messages.add(new Messages("selectedUser", "text text text text text text text text", "19/10"));
        messages.add(new Messages("selectedUser", "text text text text text text text text", "19/10"));

        messagesAdapter = new SelectedMessageAdapter(this, messages);
        ListView listView = (ListView) findViewById(R.id.list_selected_messages);
        listView.setAdapter(messagesAdapter);
    }

    private void sendMessage() {
        // editor = preferences.edit();
    }

}

