/*
Displays list of absent students
forwards list to designated email address
 */

package com.example.chapelproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class DisplayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        // get list of missing students from activating Intent (home screen)
        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("StudentList");

        // create string of names from arrayList
        // arranges each absent student on a new line
        StringBuilder message = new StringBuilder("\n");
        for (String name : myList) {
            message.append(name + "\n");
        }

        // print the list of names
        TextView textView = findViewById(R.id.listTextView);
        textView.setText("Absent Students: " + message.toString());

        // Create button listener for email button
        Button startBtn = (Button) findViewById(R.id.emailButton);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail(message.toString());
            }
        });

    }

    // Input: String of missing student names
    // Send an email with missing students
    public void sendEmail(String absentStudentsString) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ryan@belmonthill.org", "peck@belmonthill.org", "ewhite@belmonthill.org", "bradleyd@belmonthill.org"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Chapel Attendance: " + Calendar.getInstance().getTime());
        email.putExtra(Intent.EXTRA_TEXT, "Missing Students:" + absentStudentsString);

        //need this to prompt email client only
        email.setType("message/rfc822");

        //send the email
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}