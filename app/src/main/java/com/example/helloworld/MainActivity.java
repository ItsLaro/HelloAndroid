package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
    }
    protected void setButton(){
        findViewById(R.id.greet_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button", "Someone is saying 'hi'");

                TextView helloWorldMessage = (TextView) findViewById(R.id.helloworld);
                helloWorldMessage.setTextColor(getResources().getColor(R.color.colorDarkOrange));
                helloWorldMessage.setText("Glad to know someone's there!");
            }
        });
        findViewById(R.id.godark_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button", "Dark Mode enabled.");
                //Changes Background to Navy
                RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainlayout);
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorDarkNavy));
                //Changes label color & message
                TextView helloWorldMessage = (TextView) findViewById(R.id.helloworld);
                helloWorldMessage.setTextColor(getResources().getColor(R.color.colorWhite));
                helloWorldMessage.setText("Dark mode is Awesome!");
                helloWorldMessage.setTypeface(null, Typeface.BOLD);
            }
        });
        findViewById(R.id.mainlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Button", "Resetting View to Default");
                setContentView(R.layout.activity_main);
                setButton();
            }
        });


    }
}