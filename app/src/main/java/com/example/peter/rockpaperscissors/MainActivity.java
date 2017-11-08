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

        Intent mainActivityIntent = getIntent();
        Bundle extras = mainActivityIntent.getExtras();

        if (mainActivityIntent.hasExtra("resetScores")){
            String resetScoresValue = extras.getString("resetScores");
            if (resetScoresValue.equals("true")){
                resetScores();
            }
        }

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
        Game rpsGame = Game.getInstance();

        String gameResult = rpsGame.play(userHand);

        resultActivityIntent.putExtra("userHandName", this.userHand.getName());
        resultActivityIntent.putExtra("aiHandName", rpsGame.getAiHand().getName());
        resultActivityIntent.putExtra("gameResult", gameResult);
        resultActivityIntent.putExtra("userScore", rpsGame.getUserWins().toString());
        resultActivityIntent.putExtra("aiScore", rpsGame.getAiWins().toString());

        startActivity(resultActivityIntent);
    }

    public void resetScores(){
        // get Game instance (singleton)
        Game rpsGame = Game.getInstance();

        rpsGame.setUserWins(0);
        rpsGame.setAiWins(0);
    }

}
