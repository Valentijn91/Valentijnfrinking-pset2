package com.example.vfrin.valentijnfrinking_pset2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SecondActivity extends AppCompatActivity {

        Story story;            // instance of story

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            InputStream is;

            // Try to open a random file. File not found or bug in Random will create an empty story.
            try {
                Random rand = new Random();
                int value = rand.nextInt(5);
                switch (value) {
                    case 0: is = getAssets().open("madlib0_simple.txt");
                        break;
                    case 1: is = getAssets().open("madlib1_tarzan.txt");
                        break;
                    case 2: is = getAssets().open("madlib2_university.txt");
                        break;
                    case 3: is = getAssets().open("madlib3_clothes.txt");
                        break;
                    case 4: is = getAssets().open("madlib4_dance.txt");
                        break;
                    default: is = null;
                        break;
                }
            } catch (IOException e){
                e.printStackTrace();
                is = null;
            }

            if (is != null) {
                story = new Story(is);
                // Set new view
                setContentView(R.layout.activity_second);

                // Get initial number of placeholders
                int placeholderNum = story.getPlaceholderCount();
                TextView textView = (TextView) findViewById(R.id.numLeft);
                Log.d("placeholders left is", Integer.toString(placeholderNum));
                textView.setText(Integer.toString(placeholderNum));

                // Get type of first placeholder
                TextView hintView = (TextView) findViewById(R.id.fillInBox);
                hintView.setHint(story.getNextPlaceholder());

            }

        }

    public void submitWord(View view){

        // Select the text box
        EditText contentEdit = (EditText) findViewById(R.id.fillInBox);

        // Load input word and clear input box
        String word = contentEdit.getText().toString();
        Log.d("chosen word is", word);
        story.fillInPlaceholder(word);
        contentEdit.setText("");

        // update number of placeholders that is left
        int placeholdersLeft = story.getPlaceholderRemainingCount();
        TextView textView = (TextView) findViewById(R.id.numLeft);
        Log.d("placeholders left is", Integer.toString(placeholdersLeft));
        textView.setText(Integer.toString(placeholdersLeft));

        // update displayed hint or placeholder type
        contentEdit.setHint(story.getNextPlaceholder());

        if(story.isFilledIn()) {

            Log.d("Story complete", "ga naar volgend scherm");

            // Pass the story to next activity and go to next screen
            Intent getThirdScreen = new Intent(this, StoryActivity.class);
            String storyText = story.toString();
            getThirdScreen.putExtra("storyText", storyText);
            startActivity(getThirdScreen);

        }

        // End OnClick
    }




}