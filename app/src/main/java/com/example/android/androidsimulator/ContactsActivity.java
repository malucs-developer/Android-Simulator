package com.example.android.androidsimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    SharedPreferences preferences;
    ArrayList<Contacts> contacts;
    ContactsAdapter contactsAdapter;
    Button buttonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        buttonAddContact = (Button) findViewById(R.id.addContact_button);

        // show contacts from internal storage
        showContacts();

        // set OnClickListener
        setEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // update contacts
        showContacts();
    }

    private void setEvents() {
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open AddContactsActivity to add/edit a contact
                Intent intentAddContact = new Intent(ContactsActivity.this, AddContactsActivity.class);
                startActivity(intentAddContact);
            }
        });
    }

    public void showContacts() {
        contacts = new ArrayList<>();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int totalContacts = preferences.getInt("totalContacts", 0);

        for (int index = 1; index <= totalContacts; index++) {
            String name = preferences.getString("nameContact" + index, "");
            int number = preferences.getInt("numberContact" + index, 0);

            contacts.add(new Contacts(name, number));
        }

        addAdapter();
    }

    public void addAdapter() {
        contactsAdapter = new ContactsAdapter(this, contacts);
        ListView listView = (ListView) findViewById(R.id.list_contacts);
        listView.setAdapter(contactsAdapter);
    }
}
