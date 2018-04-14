package com.example.shubham.diceapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;
        rollButton =(Button) findViewById(R.id.rollbutton);

       final ImageView leftDice =(ImageView) findViewById(R.id.image_leftDice);
       final ImageView rightDice =(ImageView) findViewById(R.id.image_rightDice);
        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        final  int[] activePlayer = {1};
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int activePlayer=1;
                Log.d("Dicee", "Button is pressed");
                TextView t1 = (TextView) findViewById(R.id.player1Score);
                TextView t2 = (TextView) findViewById(R.id.player2Score);

                Random randomNumberGenerator =new Random();
                int number1 =randomNumberGenerator.nextInt(6);
                int number2 =randomNumberGenerator.nextInt(6);
                Log.d("Dicee","The random number is "+number1);
                leftDice.setImageResource(diceArray[number1]);
                rightDice.setImageResource(diceArray[number2]);
                if((number1==number2) ){
                    Toast.makeText(getApplicationContext(), "Player Changed",
                            Toast.LENGTH_SHORT).show();
                    if(activePlayer[0]==1){
                        t1.setBackgroundColor(Color.TRANSPARENT);
                        activePlayer[0]=2;
                        t2.setBackgroundColor(Color.WHITE);
                    }else{
                        t2.setBackgroundColor(Color.TRANSPARENT);
                        activePlayer[0]=1;
                        t1.setBackgroundColor(Color.WHITE);
                    }


                }else{
                    if(activePlayer[0]==1){
                        int preValue  = Integer.parseInt( t1.getText().toString())+number1+number2 +2;
                        t1.setText(preValue+"");
                        Log.d("t1","1st value is"+preValue);
                    }else{
                        int preValue  = Integer.parseInt( t2.getText().toString())+number1+number2 + 2;
                        t2.setText(preValue+"");
                        Log.d("t1"," 2nd value is"+preValue);
                    }
                    if(Integer.parseInt( t2.getText().toString())>=100 ){
                        Toast.makeText(getApplicationContext(), "Player 2 won",
                                Toast.LENGTH_LONG).show();
                        t1.setText(0+"");
                        t2.setText(0+"");
                        activePlayer[0]=1;
                        t1.setBackgroundColor(Color.WHITE);
                        t2.setBackgroundColor(Color.TRANSPARENT);
                    }
                    else if(Integer.parseInt( t1.getText().toString())>=100 ){
                        Toast.makeText(getApplicationContext(), "Player 1 won",
                                Toast.LENGTH_LONG).show();
                        t1.setText(0+"");
                        t2.setText(0+"");
                        activePlayer[0]=1;
                        t1.setBackgroundColor(Color.WHITE);
                        t2.setBackgroundColor(Color.TRANSPARENT);
                    }
                }



            }
        });
    }
}
