package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    static List<Question>  questions = new ArrayList<>();
    static int score = 0;
    static int maxScore = 0;

    Button first;
    Button second;
    Button third;
    Button fourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent oldIntent = getIntent();
        int questionNumber = oldIntent.getIntExtra("question", -1);
        if (questionNumber == 0) {
            setUpQuestions();
        }

        if (questionNumber == questions.size()) {
            end();
        }

        Button first = findViewById(R.id.answer);
        Button second = findViewById(R.id.answer1);
        Button third = findViewById(R.id.answer2);
        Button fourth = findViewById(R.id.answer3);

        TextView questionText = findViewById(R.id.questionText);

        first.setOnClickListener(unused -> {
            score += 0;
            maxScore += 3;

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);
        });

        second.setOnClickListener(unused -> {
            score += 1;
            maxScore += 3;

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);
        });

        third.setOnClickListener(unused -> {
            score += 2;
            maxScore += 3;

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);
        });

        fourth.setOnClickListener(unused -> {
            score += 3;
            maxScore += 3;

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);
        });

        questionText.setText(questions.get(questionNumber).getQuestion());



    }

    /**
     * sets up the questions. ~~my javadoc is so good~~
     */
    public void setUpQuestions() {

        //FILL OUT LATER
        List<String> firstAnswers = new ArrayList<>();
        firstAnswers.add("Python");
        firstAnswers.add("Other");
        firstAnswers.add("Java");
        firstAnswers.add("Kotlin");
        Question firstQuestion = new Question("What's your favorite language?", firstAnswers);
        questions.add(firstQuestion);

        List<String> secondAnswers = new ArrayList<>();
        secondAnswers.add("I like it, honestly");
        secondAnswers.add("It's okay, I guess");
        secondAnswers.add("Really don't like it");
        secondAnswers.add("It murdered my wife, cat, and dog");
        Question secondQuestion = new Question("What are your feelings on Microsoft Office?", secondAnswers);
        questions.add(secondQuestion);

    }

    public void end() {
        finish();
        //put code here that finishes the activity and launches the results page
    }
}
