package com.example.peter.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Hand userHand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rockBtnOnClick(View button){
        userHand = Hand.ROCK;
        initializeIntent();
    }

    public void paperBtnOnClick(View button){
        userHand = Hand.PAPER;
        initializeIntent();
    }

    public void scissorsBtnOnClick(View button){
        userHand = Hand.SCISSORS;
        initializeIntent();
    }

    public void initializeIntent(){
        Intent resultActivityIntent = new Intent(this, ResultActivity.class);

        // get Game instance (singleton)
        Game rpsGame = new Game();
//        Game rpsGame = Game.getInstance();
//        Log.d("Main Activity", "Got singleton instance");

        String gameResult = rpsGame.play(userHand);

        resultActivityIntent.putExtra("userHandName", this.userHand.getName());
        resultActivityIntent.putExtra("aiHandName", rpsGame.getAiHand().getName());
        resultActivityIntent.putExtra("gameResult", gameResult);
        resultActivityIntent.putExtra("userScore", rpsGame.getUserWins().toString());
        resultActivityIntent.putExtra("aiScore", rpsGame.getAiWins().toString());

        startActivity(resultActivityIntent);
    }

}
