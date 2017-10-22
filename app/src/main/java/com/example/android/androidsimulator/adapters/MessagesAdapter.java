package com.example.android.androidsimulator.adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.androidsimulator.activities.SelectedConversationActivity;
import com.example.android.androidsimulator.data.Messages;
import com.example.android.androidsimulator.R;

import java.util.ArrayList;


public class MessagesAdapter extends ArrayAdapter<Messages> {

    public MessagesAdapter(Activity context, ArrayList<Messages> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_messages, parent, false);
        }

        final Messages currentListMessage = getItem(position);

        // user message
        final TextView userTextView = (TextView) listItemView.findViewById(R.id.user_textView);
        userTextView.setText(currentListMessage.getUser());

        // last message of list
        TextView messageTextVIew = (TextView) listItemView.findViewById(R.id.message_textView);
        messageTextVIew.setText(currentListMessage.getMessage());

        // date of last message
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textView);
        dateTextView.setText(currentListMessage.getDate());

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check the id of contact by name
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

                String checkName = currentListMessage.getUser();
                int totalContacts = preferences.getInt("totalContacts", 0);
                int checkId = 0;

                for (int index = 1; index <= totalContacts; index++) {
                    String name = preferences.getString("nameContact" + index, "");

                    if (checkName == name) {
                        checkId = index;
                        index = totalContacts;
                    }

                }

                Intent intent = new Intent(getContext(), SelectedConversationActivity.class);
                intent.putExtra("selectedContact", checkId);
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
