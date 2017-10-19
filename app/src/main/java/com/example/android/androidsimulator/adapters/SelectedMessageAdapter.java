package com.example.android.androidsimulator.adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.androidsimulator.R;
import com.example.android.androidsimulator.data.Messages;

import java.util.ArrayList;

public class SelectedMessageAdapter extends ArrayAdapter<Messages> {

    public SelectedMessageAdapter(Activity context, ArrayList<Messages> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_selected_messages, parent, false);
        }

        final Messages currentMessage = getItem(position);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.list_selected_message);
        linearLayout.setVisibility(View.VISIBLE);

        TextView messageTextView = (TextView) listItemView.findViewById(R.id.message_textView);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_textView);

        messageTextView.setText(currentMessage.getMessage());
        dateTextView.setText(currentMessage.getDate());

        return listItemView;
    }
}
