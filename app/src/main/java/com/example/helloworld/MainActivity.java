package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
    }
    protected void setListeners() {
        findViewById(R.id.greet_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView helloWorldMessage = (TextView) findViewById(R.id.helloworld);
                helloWorldMessage.setTextColor(getResources().getColor(R.color.colorDarkOrange));
                helloWorldMessage.setText("Glad to know someone's there!");

                Log.i("Button", "User clicked 'hi'");
            }
        });

        findViewById(R.id.godark_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Alters Background to Navy
                RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainlayout);
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorDarkNavy));

                //Alters label color & text
                TextView helloWorldMessage = (TextView) findViewById(R.id.helloworld);
                helloWorldMessage.setTextColor(getResources().getColor(R.color.colorLightGray));
                helloWorldMessage.setText("Dark mode is Awesome!");
                helloWorldMessage.setTypeface(null, Typeface.BOLD);

                //Alters text field's color
                EditText editLabel = (EditText) findViewById(R.id.editLabel);
                editLabel.setHintTextColor(getResources().getColor(R.color.colorGray));
                editLabel.setHighlightColor(getResources().getColor(R.color.colorGray));

                Log.i("Button", "Dark Mode enabled.");
            }
        });

        findViewById(R.id.mainlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button", "Resetting View to Default");
                setContentView(R.layout.activity_main);
                setListeners();
            }
        });

        findViewById(R.id.edit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLabel();
            }
        });

        EditText editLabel = (EditText) findViewById(R.id.editLabel);
        editLabel.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    updateLabel();
                    return true;
                }
                return false;
            }
        });

    }

    protected void updateLabel() {
        /*
        Helper method that update's the label from the text extracted from the text field.
        To be called from the 'Edit Button' Listener and on-editor 'Enter/Done' Listener.
         */
        EditText editLabel = (EditText) findViewById(R.id.editLabel);
        String newLabel = editLabel.getText().toString();

        if (newLabel.matches("")) {
            TextView helloWorldMessage = (TextView) findViewById(R.id.helloworld);
            //Sets label to default text & color:
            helloWorldMessage.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            helloWorldMessage.setText("Hello World, from Ivan!");

            Log.i("Submit", "Empty text field; label set to default.");

        } else {
            TextView helloWorldMessage = (TextView) findViewById(R.id.helloworld);
            helloWorldMessage.setText(newLabel);
            editLabel.setText(""); //Empties the field.

            Log.i("Submit", "Text updated to '" + newLabel + "'");
        }
    }
}