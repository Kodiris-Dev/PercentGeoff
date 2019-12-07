package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button restart;
    TextView resultText;
    Bitmap imageBitmap;
    Bundle pictureBundle;
    ImageView notGeoff;
    ImageView geoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        restart = findViewById(R.id.restartButton);
        resultText = findViewById(R.id.resultText);
        notGeoff = findViewById(R.id.imageView);
        geoff = findViewById(R.id.imageView2);


        Intent oldIntent = getIntent();
        int maxScore = oldIntent.getIntExtra("maxScore", -1);
        int score = oldIntent.getIntExtra("score", -1) * 100;

        pictureBundle = oldIntent.getBundleExtra("pictureBundle");
        imageBitmap = (Bitmap) pictureBundle.get("data");


        Log.d("tag2", "height: " + imageBitmap.getHeight());
        Log.d("tag2", "width: " + imageBitmap.getWidth());
        Log.d("tag2", "config: " + imageBitmap.getConfig());

        //Bitmap display = imageBitmap.copy(imageBitmap.getConfig(),false);
        Bitmap display = Bitmap.createScaledBitmap(imageBitmap, 460, 460, false);

        if (Build.VERSION.SDK_INT >= 19) {
            //display.setWidth(150);
            //display.setHeight(150);
        }


        notGeoff.setImageBitmap(display);

        resultText.setText("You are " + score / maxScore + "% Geoff");


        restart.setOnClickListener(unused -> {
            Intent intent = new Intent(this, MainActivity.class);
            //intent.putExtra("question", 0);
            startActivity(intent);
        });
    }
}
