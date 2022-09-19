package com.example.quizapp;

public class Question {
//    the resource id's (strings.xml file) are of type int
//    in main activity we are going to refer to question id from strings.xml
    private int answerResId;
//    ansTrue is the answer to the statement like, if the statement is true or not
    private boolean ansTrue;
    private int correctAnsId;

    public Question(int answerResId, boolean ansTrue, int correctAnsId) {
        this.answerResId = answerResId;
        this.ansTrue = ansTrue;
        this.correctAnsId = correctAnsId;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isAnsTrue() {
        return ansTrue;
    }

    public void setAnsTrue(boolean ansTrue) {
        this.ansTrue = ansTrue;
    }

    public int getCorrectAnsId() {
        return correctAnsId;
    }

    public void setCorrectAnsId(int correctAnsId) {
        this.correctAnsId = correctAnsId;
    }
}
