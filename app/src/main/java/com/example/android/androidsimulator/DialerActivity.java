package com.example.android.androidsimulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DialerActivity extends AppCompatActivity {

    ImageView turnOffButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        TextView nameContact = (TextView) findViewById(R.id.nameContact_textView);
        TextView numberContact = (TextView) findViewById(R.id.numberContact_textView);
        turnOffButton = (ImageView) findViewById(R.id.turnOff);

        turnOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back to ContactsActivity
                Intent lastIntent = new Intent(DialerActivity.this, ContactsActivity.class);
                startActivity(lastIntent);

                Toast toast = Toast.makeText(DialerActivity.this, "Call canceled", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        // show the contact data on textViews
        Intent intent = getIntent();
        nameContact.setText(intent.getStringExtra("nameContact"));
        numberContact.setText(intent.getStringExtra("numberContact"));
    }
}
