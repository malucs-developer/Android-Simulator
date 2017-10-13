package com.example.android.androidsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    ContactsAdapter contactsAdapter;
    ArrayList<Contacts> contacts;
    Button buttonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        buttonAddContact = (Button) findViewById(R.id.addContact_button);
        contacts = new ArrayList<>();

        // default values for test
        addContacts();

        // set OnClickListener
        setEvents();
    }

    private void setEvents() {
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addContacts() {
        contacts.add(new Contacts("Contact One", Integer.valueOf(912976342)));
        contacts.add(new Contacts("Contact Two", Integer.valueOf(912564789)));
        contacts.add(new Contacts("Contact Three", Integer.valueOf(912098123)));

        addAdapter();
    }

    private void addAdapter() {
        contactsAdapter = new ContactsAdapter(this, contacts);
        ListView listView = (ListView) findViewById(R.id.list_contacts);
        listView.setAdapter(contactsAdapter);
    }
}
