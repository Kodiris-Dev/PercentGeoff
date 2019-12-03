package com.example.percentgeoff;

import java.util.List;

public class Question {
    private String question;
    private List<String> answers;
    private int answer;
    Question(String q, List<String> a) {
        question = q;
        answers = a;
    }

    public List<String> getAnswers() {
        return answers;
    }
    public void setAnswer(int set) {
        answer = set;
    }
    public int getAnswer() {
        return answer;
    }
    public String getQuestion() {
        return question;
    }

}
