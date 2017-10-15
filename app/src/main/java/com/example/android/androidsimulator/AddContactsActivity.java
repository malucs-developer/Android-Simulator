package com.example.android.androidsimulator;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactsActivity extends AppCompatActivity {

    Toast toast;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText nameContact;
    EditText numberContact;
    Button buttonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        nameContact = (EditText) findViewById(R.id.nameContact_editText);
        numberContact = (EditText) findViewById(R.id.numberContact_editText);
        buttonAddContact = (Button) findViewById(R.id.addContact_button);

        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
    }

    private void addContact() {
        // SharedPreferences to save data on internal storage
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        int totalContacts = preferences.getInt("totalContacts", 0);

        CharSequence validationMessage;
        String name = String.valueOf(nameContact.getText());
        String number = String.valueOf(numberContact.getText());

        // validation of contact
        if (name.isEmpty()) {
            validationMessage = "You need to insert a name";
        }
        else if (number.isEmpty()) {
            validationMessage = "You need to insert a number";
        }
        else {
            validationMessage = "Added contact";
            totalContacts += 1;

            // add info of contact on internal storage
            editor.putInt("totalContacts", totalContacts);
            editor.putString("nameContact" + totalContacts, name);
            editor.putInt("numberContact" + totalContacts, Integer.valueOf(number));
            editor.apply();

            // clear EditTexts
            nameContact.setText("");
            numberContact.setText("");
        }

       toast = Toast.makeText(this, validationMessage, Toast.LENGTH_SHORT);
       toast.show();
    }
}
