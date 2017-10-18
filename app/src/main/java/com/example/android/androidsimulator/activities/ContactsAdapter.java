package com.example.android.androidsimulator.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.androidsimulator.data.Contacts;
import com.example.android.androidsimulator.R;

import java.util.ArrayList;

public class ContactsAdapter extends ArrayAdapter<Contacts> {

    public ContactsAdapter(Activity context, ArrayList<Contacts> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_contacts, parent, false);
        }

        final Contacts currentContact = getItem(position);

        // TextViews with name and number contact
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_textView);
        nameTextView.setText(currentContact.getName());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.number_textView);
        numberTextView.setText(String.valueOf(currentContact.getNumber()));

        // setOnClickListener of Dialer / Send Message / Edit Contact
        // open DialerActivity
        ImageView dialer = (ImageView) listItemView.findViewById(R.id.dialer_imageView);
        dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDialer = new Intent(getContext(), DialerActivity.class);

                intentDialer.putExtra("nameContact", currentContact.getName());
                intentDialer.putExtra("numberContact", String.valueOf(currentContact.getNumber()));

                getContext().startActivity(intentDialer);
            }
        });

        // send message
        ImageView sendMessage = (ImageView) listItemView.findViewById(R.id.sendMessage_imageView);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // open AddContactsActivity to edit the selected contact
        ImageView editContact = (ImageView) listItemView.findViewById(R.id.editContact_imageView);
        editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddContactsActivity.class);

                // get data of selected contact and send to AddContactsActivity
                intent.putExtra("idContact", position + 1);
                intent.putExtra("nameContact", currentContact.getName());
                intent.putExtra("numberContact", String.valueOf(currentContact.getNumber()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}