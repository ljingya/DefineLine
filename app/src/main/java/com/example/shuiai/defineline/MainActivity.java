package com.example.shuiai.defineline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefineLineView lineView = (DefineLineView) findViewById(R.id.lineView);
        String[] textY = {"10k", "20k", "30k"};
        lineView.setTextY(textY);
    }
}
