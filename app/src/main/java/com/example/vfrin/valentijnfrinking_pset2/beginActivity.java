package com.example.vfrin.valentijnfrinking_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class beginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
    }

    public void NextScreen(View view) {

        //make a new intent
        Intent GoToSecondActivity = new Intent(this, SecondActivity.class);

        // start a new activity and close the current one
        startActivity(GoToSecondActivity);
        finish();
    }
}
