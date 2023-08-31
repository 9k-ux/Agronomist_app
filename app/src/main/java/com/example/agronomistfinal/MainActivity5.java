//
package com.example.agronomistfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
TextView textView;
String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        TextView textView = findViewById(R.id.textView12);

        Bundle extras = getIntent().getExtras();
        String userName;

        if (extras != null) {
            id = extras.getString("name");
            textView.setText(id);
            // and get whatever type user account id is
        }

    }
}