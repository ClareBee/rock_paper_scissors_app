package com.example.peter.rockpaperscissors;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String resetScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.resetScores = "false";

        Intent resultActivityIntent = getIntent();
        Bundle extras = resultActivityIntent.getExtras();


        TextView userHand = (TextView) findViewById(R.id.user_hand);
        userHand.setText("You chose "+ extras.getString("userHandName") + ".");

        TextView aiHand = (TextView) findViewById(R.id.ai_hand);
        aiHand.setText("The Robot chose "+ extras.getString("aiHandName") + ".");

        TextView gameResult = (TextView) findViewById(R.id.game_output);
        gameResult.setText(extras.getString("gameResult"));

        TextView user_score = (TextView) findViewById(R.id.user_score_text);
        user_score.setText(extras.getString("userScore"));

        TextView ai_score = (TextView) findViewById(R.id.ai_score_text);
        ai_score.setText(extras.getString("aiScore"));

        // change text colour dependent on score
        amendTextColours(extras, user_score, ai_score);
    }

    public void playAgainBtnOnClick(View button){
        Intent mainActivityIntent = new Intent(this, MainActivity.class);

        mainActivityIntent.putExtra("resetScores", this.resetScores);

        startActivity(mainActivityIntent);
    }

    public void resetScoresBtnOnClick(View button){
        this.resetScores = "true";

        TextView user_score = (TextView) findViewById(R.id.user_score_text);
        user_score.setText("0");

        TextView ai_score = (TextView) findViewById(R.id.ai_score_text);
        ai_score.setText("0");

        user_score.setTextColor(Color.parseColor("#FF36474F"));
        ai_score.setTextColor(Color.parseColor("#FF36474F"));
    }

    public void amendTextColours(Bundle extras, TextView user_score, TextView ai_score){
        Integer userScoreInt = Integer.parseInt(extras.getString("userScore"));
        Integer aiScoreInt = Integer.parseInt(extras.getString("aiScore"));

        if (userScoreInt > aiScoreInt){
            user_score.setTextColor(Color.parseColor("#00bc3e"));
            ai_score.setTextColor(Color.parseColor("#bc0000"));
        } else if (aiScoreInt > userScoreInt){
            ai_score.setTextColor(Color.parseColor("#00bc3e"));
            user_score.setTextColor(Color.parseColor("#bc0000"));
        }
    }
}
