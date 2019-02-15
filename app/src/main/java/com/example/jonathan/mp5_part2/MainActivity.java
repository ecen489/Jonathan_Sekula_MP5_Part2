package com.example.jonathan.mp5_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    private static final int REQ_CODE = 100;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.score);

        intent = new Intent(this, QuestionActivity.class);

        ListView listView = findViewById(R.id.topics);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent.putExtra("topic", "gaming");
                        break;
                    case 1:
                        intent.putExtra("topic", "music");
                        break;
                    case 2:
                        intent.putExtra("topic", "sports");
                        break;
                }
                startActivityForResult(intent, REQ_CODE);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQ_CODE) {
            int correct = intent.getIntExtra("correct", 0);
            int score = Integer.parseInt(textView.getText().toString()) + correct;
            textView.setText(String.valueOf(score));

        }
    }

    public void Reset(View view) {
        textView.setText("0");
    }
}
