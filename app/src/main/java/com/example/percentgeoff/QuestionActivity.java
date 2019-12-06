package com.example.percentgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    static List<Question>  questions = new ArrayList<>();
    int score;
    static int maxScore = 0;

    Button first;
    Button second;
    Button third;
    Button fourth;

    int questionNumber;

    static boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent oldIntent = getIntent();
        questionNumber = oldIntent.getIntExtra("question", 0);
        Log.d("questionNum", "" + questionNumber);


        if (firstTime) {
            setUpQuestions();
            maxScore = questions.size() * 3;
            score = 0;
            firstTime = false;
        }
        if (questionNumber == -1) {
            questionNumber = 0;
            score = 0;
        }

        score = oldIntent.getIntExtra("score", 0);

        /*if (questionNumber == questions.size()) {
            end();
        }*/

        List<String> answers = questions.get(questionNumber).getAnswers();

        Log.d("tag", "didn't end, question: " + questionNumber + ", array size: " + questions.size());

        first = findViewById(R.id.answer);
        second = findViewById(R.id.answer1);
        third = findViewById(R.id.answer2);
        fourth = findViewById(R.id.answer3);

        TextView questionText = findViewById(R.id.questionText);

        questionText.setText(questions.get(questionNumber).getQuestion());

        first.setOnClickListener(unused -> {
            //score += 0;
            //maxScore += 3;

            /*if (questionNumber + 1 == questions.size()) {
                end();
            }

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);*/
            end();
        });

        first.setText(answers.get(0));

        second.setOnClickListener(unused -> {
            score += 1;
            //maxScore += 3;

            /*if (questionNumber + 1 == questions.size()) {
                end();
            }

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);*/
            end();
        });

        second.setText(answers.get(1));

        third.setOnClickListener(unused -> {
            score += 2;
            //maxScore += 3;

            /*Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);

            if (questionNumber + 1 == questions.size()) {
                end();
            }

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);


            startActivity(intent);*/
            end();
        });

        third.setText(answers.get(2));

        fourth.setOnClickListener(unused -> {
            score += 3;
            //maxScore += 3;

            /*if (questionNumber + 1 == questions.size()) {
                end();
            }

            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("question", questionNumber + 1);
            startActivity(intent);*/
            end();
        });

        fourth.setText(answers.get(3));





    }

    /**
     * sets up the questions. ~~my javadoc is so good~~
     */
    public void setUpQuestions() {

        //FILL OUT MORE LATER
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

        List<String> thirdAnswers = new ArrayList<>();
        thirdAnswers.add("We should all be worshipping it");
        thirdAnswers.add("I like it");
        thirdAnswers.add("I dislike it");
        thirdAnswers.add("How do you even copy and paste?");
        Question thirdQuestion = new Question("What are your feelings on Windows?", thirdAnswers);
        questions.add(thirdQuestion);

        List<String> fourthAnswers = new ArrayList<>();
        fourthAnswers.add("Formal Attire");
        fourthAnswers.add("Ripped Jeans");
        fourthAnswers.add("An intimidatingly sized baseball cap");
        fourthAnswers.add("The tears of student’s cries for help on the MP");
        Question fourthQuestion = new Question("What would you wear to a CS class on a warm sunny day in Champaign?", fourthAnswers);
        questions.add(fourthQuestion);

        List<String> fifthAnswers = new ArrayList<>();
        fifthAnswers.add("11 pipers piping");
        fifthAnswers.add("11 Checkstyle errors");
        fifthAnswers.add("11 Machine Projects");
        fifthAnswers.add("Not enough TA’s for office hours");
        Question fifthQuestion = new Question("On the 11th day of christmas my true love gave to me...", fifthAnswers);
        questions.add(fifthQuestion);

        List<String> sixthAnswers = new ArrayList<>();
        sixthAnswers.add("ArrayList list = new ArrayList<>();");
        sixthAnswers.add("LinkedList list = new LinkedList<>();");
        sixthAnswers.add("List list = new ArrayList<>();");
        sixthAnswers.add("List list = new LinkedList<>();");
        Question sixthQuestion = new Question("What’s your favorite way to declare a List in Java?", sixthAnswers);
        questions.add(sixthQuestion);

        List<String> seventhAnswers = new ArrayList<>();
        sixthAnswers.add("Piazza");
        sixthAnswers.add("Queue");
        sixthAnswers.add("Forum");
        sixthAnswers.add("Office Hours");
        Question seventhQuestion = new Question("What’s your favorite platform for students to get help on assignments?", seventhAnswers);
        questions.add(seventhQuestion);

    }

    public void end() {
        Log.d("tag", "ended");


        //return intent;

        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("question", questionNumber + 1);
        intent.putExtra("score", score);

        if (questionNumber + 1 == questions.size()) {
            intent = new Intent(this, ResultActivity.class);
            intent.putExtra("maxScore", maxScore);
            intent.putExtra("score", score);
        }


        startActivity(intent);


        //startActivity(intent);

        finish();
        //put code here that finishes the activity and launches the results page
    }
}
