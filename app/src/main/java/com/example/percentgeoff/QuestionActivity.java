package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    static List<Question>  questions;
    static int score;
    static int maxScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent oldIntent = getIntent();
        int questionNumber = oldIntent.getIntExtra("question", -1);
        if (questionNumber == 0) {
            setUpQuestions();
        }


        for (int i = 0; i < questions.size(); i++) {

        }

    }

    public void setUpQuestions() {
        //FILL OUT LATER
    }
}
