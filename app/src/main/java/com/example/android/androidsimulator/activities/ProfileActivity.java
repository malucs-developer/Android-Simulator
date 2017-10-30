package com.example.android.androidsimulator.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.androidsimulator.R;
import com.example.android.androidsimulator.data.Profile;
import com.example.android.androidsimulator.utils.ProfileUtils;

public class ProfileActivity extends AppCompatActivity {

    private static final String urlJson = "https://api.myjson.com/bins/1bjq1n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ProfileAsyncTask task = new ProfileAsyncTask();
        task.execute(urlJson);
    }

    private void updateUi(Profile profile) {
        TextView textName = (TextView) findViewById(R.id.name_textView);
        TextView textAge = (TextView) findViewById(R.id.age_textView);
        TextView textHobbies = (TextView) findViewById(R.id.hobbies_textView);

        textName.setText(profile.getName());
        textAge.setText(profile.getAge().toString());
        textHobbies.setText(profile.getHobbies());
    }

    private class ProfileAsyncTask extends AsyncTask<String, Void, Profile> {

        protected Profile doInBackground(String... urls) {
            Profile result = ProfileUtils.fetchProfileData(urlJson);
            return result;
        }

        protected void onPostExecute(Profile result) {
            updateUi(result);
        }
    }
}
