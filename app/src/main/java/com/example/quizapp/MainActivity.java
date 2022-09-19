package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTrue, btnFalse;
    ImageButton btnNext, btnPrev;
    TextView tvQuestion, tvCorrectAnswer;

    Question[] questions = new Question[] {
            new Question(R.string.question_adoption, true, R.string.question_adoption_ans),
            new Question(R.string.question_geography, false,R.string.question_geography_ans),
            new Question(R.string.question_fruitBowl, false, R.string.question_fruitBowl_ans),
            new Question(R.string.question_femalePresident, true, R.string.question_femalePresident_ans),
            new Question(R.string.question_ironMan, true, R.string.question_ironMan_ans),
            new Question(R.string.question_currPresident, false, R.string.question_currPresident_ans),
            new Question(R.string.question_assam, false, R.string.question_assam_ans),
            new Question(R.string.question_language, false, R.string.question_language_ans),
            new Question(R.string.question_richestMan, false, R.string.question_richestMan_ans),
            new Question(R.string.question_richestWoman, true, R.string.question_richestWoman_ans)
    };

    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrue = findViewById(R.id.btnTrue);
        btnFalse = findViewById(R.id.btnFalse);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvCorrectAnswer = findViewById(R.id.tvCorrectAnswer);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnNext) {
            tvCorrectAnswer.setVisibility(View.GONE);
            currentQuestionIndex++;
            updateQuestion();
        }
        else if(view.getId() == R.id.btnPrev) {
            tvCorrectAnswer.setVisibility(View.GONE);
            currentQuestionIndex--;
            updateQuestion();
        }
        else if(view.getId() == R.id.btnTrue){
            checkAnswer(true);
        }
        else if(view.getId() == R.id.btnFalse){
            checkAnswer(false);
        }
    }

    private void updateQuestion() {
        Log.d("Current", "onClick: "+ currentQuestionIndex);
        if(currentQuestionIndex<0) {
            currentQuestionIndex = questions.length-1;
        }
        tvQuestion.setText(questions[currentQuestionIndex%questions.length].getAnswerResId());
    }

    private void checkAnswer(boolean userChosenAnswer) {
        boolean isAnswerTrue = questions[currentQuestionIndex].isAnsTrue();
        int toastMessage;

        if(userChosenAnswer == isAnswerTrue) {
            toastMessage = R.string.correct_ans;
        }
        else {
            toastMessage = R.string.wrong_ans;
            String correctAnswerId = getString(R.string.correct_ans_is_text) + getString(questions[currentQuestionIndex].getCorrectAnsId());
            tvCorrectAnswer.setText(correctAnswerId);
            tvCorrectAnswer.setVisibility(View.VISIBLE);
        }

        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}