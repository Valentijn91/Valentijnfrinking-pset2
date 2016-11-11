package com.example.vfrin.valentijnfrinking_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {
    TextView output;    // textfield for text of story

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        TextView results = (TextView)findViewById(R.id.output);
        Bundle bundle = getIntent().getExtras();
        String story = bundle.getString("storyText");
        results.setText(story);
    }

    /** Go back to home when clicked, so the user can start a new story */
    public void StartOver(View view) {
        // make a new intent
        Intent goToHome = new Intent(this, beginActivity.class);

        // go back to home, close current activity
        startActivity(goToHome);
        finish();
    }
}