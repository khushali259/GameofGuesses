package com.example.gameofguesses;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GuessActivity extends AppCompatActivity {
    TextView result;
    int number;
    int guesses;
    int count=0;
    int scoreWin;
    int scoreLoss;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_MESSAGE1 = "com.example.myfirstapp.MESSAGE1";
    public final static String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE2";

    String reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_1);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);
        String message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_3);
        Intent intent1=new Intent(GuessActivity.this,MainActivity.class);

        number = Integer.parseInt(message);
        guesses = Integer.parseInt(message1);
        scoreWin=Integer.parseInt(message2);
        scoreLoss=Integer.parseInt(message3);
        final Button button = findViewById(R.id.guessbutton_button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText guessno=(EditText) findViewById(R.id.edittext_edit_text);
                RelativeLayout layout=(RelativeLayout) findViewById(R.id.layout);
                count++;

                if (TextUtils.isEmpty(guessno.getText())){
                    result=(TextView) findViewById(R.id.message_text_view);
                    reply ="Oops\nInvalid Input";
                    result.setText(reply);
                    layout.setBackgroundResource(R.color.darkestRed);
                    count--;
                }
                else if(count>guesses){
                    result=(TextView) findViewById(R.id.message_text_view);
                    reply="You have exceeded the number of tries\nYou lose :(";
                    result.setText(reply);
                    button.setEnabled(false);
                    layout.setBackgroundResource(R.color.darkestRed);
                    scoreLoss++;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent1=new Intent(GuessActivity.this,MainActivity.class);
                            intent1.putExtra(EXTRA_MESSAGE,Integer.toString(scoreWin));
                            intent1.putExtra(EXTRA_MESSAGE1,Integer.toString(scoreLoss));
                            startActivity(intent1);
                        }
                    },3000);

                }


                else if (count<=guesses){


                    String value=guessno.getText().toString();
                    int Guessno=Integer.parseInt(value);
                    if (Guessno==number){
                        result=(TextView) findViewById(R.id.message_text_view);
                        reply="Congratulations...you guessed the correct age";
                        result.setText(reply);
                        button.setEnabled(false);
                        layout.setBackgroundResource(R.color.darkestGreen);
                        scoreWin++;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1=new Intent(GuessActivity.this,MainActivity.class);
                                intent1.putExtra(EXTRA_MESSAGE,Integer.toString(scoreWin));
                                intent1.putExtra(EXTRA_MESSAGE1,Integer.toString(scoreLoss));
                                startActivity(intent1);
                            }
                        },3000);

                        }
                    else if (Guessno>number) {
                        result=(TextView) findViewById(R.id.message_text_view);
                        reply="The age you've guessed is greater than required\nTry Again";
                        result.setText(reply);
                        if (Math.abs(number-Guessno)<=2){
                            layout.setBackgroundResource(R.color.darkerGreen);
                        }
                        else if ((Math.abs(number-Guessno)<=5)&&(Math.abs(number-Guessno)>2)){
                            layout.setBackgroundResource(R.color.darkGreen);
                        }
                        else if ((Math.abs(number-Guessno)<=10)&&(Math.abs(number-Guessno)>5)){
                            layout.setBackgroundResource(R.color.Green);
                        }
                        else if ((Math.abs(number-Guessno)<=15)&&(Math.abs(number-Guessno)>10)){
                            layout.setBackgroundResource(R.color.lightGreen);
                        }
                        else if ((Math.abs(number-Guessno)<=20)&&(Math.abs(number-Guessno)>15)){
                            layout.setBackgroundResource(R.color.lightRed);
                        }
                        else if ((Math.abs(number-Guessno)<=25)&&(Math.abs(number-Guessno)>20)){
                            layout.setBackgroundResource(R.color.red);
                        }
                        else if ((Math.abs(number-Guessno)<=30)&&(Math.abs(number-Guessno)>25)){
                            layout.setBackgroundResource(R.color.darkRed);
                        }
                        else if ((Math.abs(number-Guessno)<=35)&&(Math.abs(number-Guessno)>30)){
                            layout.setBackgroundResource(R.color.darkerRed);
                        }
                        else if (Math.abs(number-Guessno)>35){
                            layout.setBackgroundResource(R.color.darkestRed);
                        }

                    }
                    else if (Guessno<number) {
                        result=(TextView) findViewById(R.id.message_text_view);
                        reply="The age you've guessed is lesser than required\nTry Again";
                        result.setText(reply);
                        if (Math.abs(number-Guessno)<=2){
                            layout.setBackgroundResource(R.color.darkerGreen);
                        }
                        else if ((Math.abs(number-Guessno)<=5)&&(Math.abs(number-Guessno)>2)){
                            layout.setBackgroundResource(R.color.darkGreen);
                        }
                        else if ((Math.abs(number-Guessno)<=10)&&(Math.abs(number-Guessno)>5)){
                            layout.setBackgroundResource(R.color.Green);
                        }
                        else if ((Math.abs(number-Guessno)<=15)&&(Math.abs(number-Guessno)>10)){
                            layout.setBackgroundResource(R.color.lightGreen);
                        }
                        else if ((Math.abs(number-Guessno)<=20)&&(Math.abs(number-Guessno)>15)){
                            layout.setBackgroundResource(R.color.lightRed);
                        }
                        else if ((Math.abs(number-Guessno)<=25)&&(Math.abs(number-Guessno)>20)){
                            layout.setBackgroundResource(R.color.red);
                        }
                        else if ((Math.abs(number-Guessno)<=30)&&(Math.abs(number-Guessno)>25)){
                            layout.setBackgroundResource(R.color.darkRed);
                        }
                        else if ((Math.abs(number-Guessno)<=35)&&(Math.abs(number-Guessno)>30)){
                            layout.setBackgroundResource(R.color.darkerRed);
                        }
                        else if (Math.abs(number-Guessno)>35){
                            layout.setBackgroundResource(R.color.darkestRed);
                        }


                    }
                }

            }

        });









        }



}






