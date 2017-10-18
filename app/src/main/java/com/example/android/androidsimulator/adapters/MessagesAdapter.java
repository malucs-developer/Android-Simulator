package com.example.android.androidsimulator.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        TextView userTextView = (TextView) listItemView.findViewById(R.id.user_textView);
        userTextView.setText(currentListMessage.getUser());

        // last message of list
        TextView messageTextVIew = (TextView) listItemView.findViewById(R.id.message_textView);
        messageTextVIew.setText(currentListMessage.getMessage());

        // date of last message
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textView);
        dateTextView.setText(currentListMessage.getDate());

        return listItemView;
    }
}
