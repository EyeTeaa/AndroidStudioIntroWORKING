package com.example.androidstudiointro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void upClick(View view)
    {
        Toast.makeText(this, "You clicked the up button", Toast.LENGTH_SHORT).show();
        num++;
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        countTextView.setText("Number of EagleDucks: " + num);
    }//end up count button handler

    public void downClick(View v)
    {
        Toast.makeText(this, "You clicked the down button", Toast.LENGTH_SHORT).show();
        num--;
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        countTextView.setText("Number of EagleDucks: " + num);
    }//end down count button handler

    public void openDialog(View v )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset count");
        builder.setPositiveButton("Yeppers", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Of Course!", Toast.LENGTH_SHORT).show();
                num = 0 ;
                //need to update text again
                updateTextView();
            }//end onClick overriden method
        });//end set positive or "Yes" button handler

        builder.setNegativeButton("No Way!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //method is empty because all it needs to do is close the dialog
            }//end onClick
        });//end set negative button

        AlertDialog resetDialog = builder.create();
        resetDialog.show();
    }//end open reset dialog handler


    public void updateTextView()
    {
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        countTextView.setText("Number of EagleDucks: " + num);
    }





}//end mainActivity class