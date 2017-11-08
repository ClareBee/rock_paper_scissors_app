package com.example.peter.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        TextView userHand = (TextView) findViewById(R.id.user_hand);
        userHand.setText("You chose "+ extras.getString("userHandName") + ".");

        TextView aiHand = (TextView) findViewById(R.id.ai_hand);
        aiHand.setText("The Robot chose "+ extras.getString("aiHandName") + ".");

        TextView gameResult = (TextView) findViewById(R.id.game_output);
        gameResult.setText(extras.getString("gameResult"));

    }
}
