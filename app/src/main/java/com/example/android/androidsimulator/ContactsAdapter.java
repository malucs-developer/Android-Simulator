package com.example.android.androidsimulator;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter  extends ArrayAdapter<Contacts> {

    public ContactsAdapter(Activity context, ArrayList<Contacts> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            View itemListViewm = convertView;
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_contacts, parent, false);
        }

        Contacts currentContact = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_textView);
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.number_textView);

        nameTextView.setText(currentContact.getName());
        numberTextView.setText(currentContact.getNumber());

        return listItemView;
    }
}