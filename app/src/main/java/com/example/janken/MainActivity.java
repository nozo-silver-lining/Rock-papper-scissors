package com.example.janken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int opponentHand;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.text);
        final TextView subtext = (TextView)findViewById(R.id.subtext);
        final TextView scoreText = (TextView)findViewById(R.id.scoreText);
        Button rock = (Button)findViewById(R.id.rock);
        Button scissors = (Button)findViewById(R.id.scissors);
        Button paper = (Button)findViewById(R.id.paper);
        Button start = (Button)findViewById(R.id.start);


        //opponentHand_start "start"
       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               opponentHand = decideOpponentHand();
               String opponentHandText = changeTextOpponentHand(opponentHand);
               text.setText(opponentHandText);
           }
       });

        //opponentHand 1  "rock"
        //opponentHand 2  "scissors"
        //opponentHand 3  "paper"
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideGame(1, opponentHand, subtext);
                opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                text.setText(opponentHandText);
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideGame(2, opponentHand, subtext);
                opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                text.setText(opponentHandText);
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decideGame(3, opponentHand, subtext);
                opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                text.setText(opponentHandText);
            }
        });
    }
    String changeTextOpponentHand(int hand){
        String handText = "";
        if(hand == 1) handText = "グー";
        else if(hand == 2) handText = "チョキ";
        else if(hand == 3) handText = "パー";
        return handText;
    }
    int decideOpponentHand(){
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }
    void decideGame(int playerHand, int opponentHand, TextView decidetext){
        String decision;
        if(playerHand == opponentHand) {
            decision = "あいこ";
            score +=1;
        }
        else if((playerHand == 3 && opponentHand ==1) || (playerHand+1 == opponentHand)){
            decision = "勝ち";
            score += 2;
        }
        else {
            decision = "負け";
            score -= 1;
        }
        decidetext.setText(decision);
    }
}
