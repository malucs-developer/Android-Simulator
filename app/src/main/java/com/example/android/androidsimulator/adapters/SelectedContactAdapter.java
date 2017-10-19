package com.example.android.androidsimulator.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.androidsimulator.R;
import com.example.android.androidsimulator.data.Contacts;

import java.util.ArrayList;

public class SelectedContactAdapter extends ArrayAdapter<Contacts> {

    public SelectedContactAdapter(Activity context, ArrayList<Contacts> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_selected_messages, parent, false);
        }

        final Contacts currentContact = getItem(position);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.list_select_contact);
        linearLayout.setVisibility(View.VISIBLE);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nameContact_textView);
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.numberContact_textView);

        nameTextView.setText(currentContact.getName());
        numberTextView.setText(String.valueOf(currentContact.getNumber()));

        return listItemView;
    }

}
