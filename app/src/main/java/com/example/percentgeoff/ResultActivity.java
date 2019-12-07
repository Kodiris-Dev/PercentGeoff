package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button restart;
    TextView resultText;
    Bitmap imageBitmap;
    Bundle pictureBundle;
    ImageView notGeoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        restart = findViewById(R.id.restartButton);
        resultText = findViewById(R.id.resultText);
        notGeoff = findViewById(R.id.imageView);


        Intent oldIntent = getIntent();
        int maxScore = oldIntent.getIntExtra("maxScore", -1);
        int score = oldIntent.getIntExtra("score", -1) * 100;

        pictureBundle = oldIntent.getBundleExtra("pictureBundle");
        imageBitmap = (Bitmap) pictureBundle.get("data");

        notGeoff.setImageBitmap(imageBitmap);

        resultText.setText("You are " + score / maxScore + "% Geoff");


        restart.setOnClickListener(unused -> {
            Intent intent = new Intent(this, MainActivity.class);
            //intent.putExtra("question", 0);
            startActivity(intent);
        });
    }
}
