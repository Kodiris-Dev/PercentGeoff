package com.example.percentgeoff;

public class Question {
    private String question;
    private String[] answers;
    private int answer;
    Question(String q, String[] a) {
        question = q;
        answers = a;
    }

    public String[] getAnswers() {
        return answers;
    }
    public void setAnswer(int set) {
        answer = set;
    }
    public int getAnswer() {
        return answer;
    }

}
