/*
Gridview adapter to read all students from an arraylist
loads the names into functional buttons to track attendance

adapted from: https://www.geeksforgeeks.org/gridview-in-android-with-example/
 */


package com.example.chapelproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class GVadapter extends ArrayAdapter<String> {

    public GVadapter(@NonNull Context context, ArrayList<String> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        // Get student ("J Doe-Form VI") from arraylist attatched to adapter
        String student = getItem(position);
        // Isolate student name if not blank
        String studentName = student;
        if (studentName.length() > 2){
            studentName = studentName.substring(0, studentName.indexOf("-"));
        }

        // Initialize a toggle button for each student
        ToggleButton studentBTN = listitemView.findViewById(R.id.idBTNStudent);
        studentBTN.setText(studentName);
        studentBTN.setTextSize(10);
        studentBTN.setTextOff(studentName);
        studentBTN.setTextOn(studentName);

        // if student is absent
        if (MainActivity.absentStudents.contains(student)){
            studentBTN.setBackgroundColor(0xFFFF0000); // RED
        }
        // if student is present, set students to white and blanks to grey
        else{
            if (studentName.length() > 2){
                studentBTN.setBackgroundColor(0xbdf9ca); // WHITE
            }
            else {
                studentBTN.setBackgroundColor(0xFFCCCCCC); // GREY
            }
        }


        // button toggled checker (present/absent)
        studentBTN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //IS PRESENT
                if (isChecked) {
                    studentBTN.setBackgroundColor(0xbdf9ca); // WHITE
                    while(MainActivity.absentStudents.remove(student)); //removes all instances
                }
                // IS ABSENT
                else {
                    studentBTN.setBackgroundColor(0xFFFF0000); // RED
                    MainActivity.absentStudents.add(student); //appends student to absent list
                }
            }
        });

        return listitemView;
    }
}