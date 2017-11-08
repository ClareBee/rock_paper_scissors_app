package com.example.peter.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Intent i = new Intent(this, ResultActivity.class);

        Game rpsGame = new Game();
        String gameResult = rpsGame.play(userHand);

        i.putExtra("userHandName", this.userHand.getName());
        i.putExtra("aiHandName", rpsGame.getAiHand().getName());
        i.putExtra("gameResult", gameResult);

        startActivity(i);
    }

}
