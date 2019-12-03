package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(unused -> {
            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", 0);
            startActivity(intent);
        });
    }
}
