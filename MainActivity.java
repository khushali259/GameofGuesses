package com.example.gameofguesses;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_MESSAGE_1 = "com.example.myfirstapp.MESSAGE_1";
    public final static String EXTRA_MESSAGE_2 = "com.example.myfirstapp.MESSAGE_2";
    public final static String EXTRA_MESSAGE_3 = "com.example.myfirstapp.MESSAGE_3";
    String message;
    String message1;
    int scoreWin = 0;
    int scoreLoss = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button random = findViewById(R.id.random_button);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNum = new Random().nextInt(100) + 1;

                EditText editText = (EditText) findViewById(R.id.enter_edit_text);
                editText.setText(Integer.toString(randomNum), TextView.BufferType.EDITABLE);


            }
        });

    }

    public void sendMessage(View view) {


        EditText editText = (EditText) findViewById(R.id.enter_edit_text);
        EditText editText1 = (EditText) findViewById(R.id.tries_edit_text);
        if (TextUtils.isEmpty(editText.getText().toString()) || TextUtils.isEmpty(editText1.getText().toString())) {
            Context context = getApplicationContext();
            CharSequence text = "Please enter all the required data";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {

            Intent intent = new Intent(this, GuessActivity.class);
            message = editText.getText().toString();
            message1 = editText1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            intent.putExtra(EXTRA_MESSAGE_1, message1);
            intent.putExtra(EXTRA_MESSAGE_2, Integer.toString(scoreWin));
            intent.putExtra(EXTRA_MESSAGE_3, Integer.toString(scoreLoss));
            this.startActivity(intent);
        }
    }


    public void seeScore(View view) {

        try {

            Intent intent1 = getIntent();

            scoreWin = Integer.parseInt(intent1.getStringExtra(GuessActivity.EXTRA_MESSAGE));
            scoreLoss = Integer.parseInt(intent1.getStringExtra(GuessActivity.EXTRA_MESSAGE1));


            Context context = getApplicationContext();
            CharSequence text = "Number of Wins:" + scoreWin + "\nNumber of Losses:" + scoreLoss;
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = "Number of Wins:" + scoreWin + "\nNumber of Losses:" + scoreLoss;
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}








