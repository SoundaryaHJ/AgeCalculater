package com.example.agecalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userDOB= editText.getText().toString().trim();
                int year = Calendar.getInstance().get(Calendar.YEAR);

                if(userDOB.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter Birth Year", Toast.LENGTH_SHORT).show();
                } else if(userDOB.compareTo(String.valueOf(year)) > 0)
                {
                    Toast.makeText(MainActivity.this, "Year should be less than current year", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int myAge = year - Integer.parseInt(userDOB);
                    textView.setText("Your Age is " +myAge+ " years.");
                }



            }
        });
    }
}