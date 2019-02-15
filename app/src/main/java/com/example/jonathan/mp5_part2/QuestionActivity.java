package com.example.jonathan.mp5_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    Intent intent;
    EditText editText;
    TextView textView;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        editText = findViewById(R.id.answer);
        textView = findViewById(R.id.question);

        intent = getIntent();
        String topic = intent.getStringExtra("topic");

        String[] questions = new String[3];
        String[] answers = new String[3];

        switch (topic) {
            case "gaming":
                questions = this.getResources().getStringArray(R.array.questions_gaming_array);
                answers = this.getResources().getStringArray(R.array.answers_gaming_array);
                break;
            case "music":
                questions = this.getResources().getStringArray(R.array.questions_music_array);
                answers = this.getResources().getStringArray(R.array.answers_music_array);
                break;
            case "sports":
                questions = this.getResources().getStringArray(R.array.questions_sports_array);
                answers = this.getResources().getStringArray(R.array.answers_sports_array);
                break;
        }

        Random random = new Random();
        int index = random.nextInt(2);

        String question = questions[index];
        textView.setText(question);
        answer = answers[index];

    }

    public void Submit(View view) {
        boolean correct = answer.matches(editText.getText().toString());
        intent = new Intent();
        if (correct) {
            intent.putExtra("correct", 1);
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
        }
        else {
            intent.putExtra("correct", 0);
            Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show();
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
