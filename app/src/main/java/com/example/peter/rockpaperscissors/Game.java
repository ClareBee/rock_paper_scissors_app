package com.example.peter.rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Peter on 08/11/2017.
 */

public class Game {

    private String gameName;
    private ArrayList<Hand> hands;
    private Hand userHand;
    private Hand aiHand;
    private boolean gameWon;
    private String winnerName;
    private Hand winningHand;
    private Integer userWins;
    private Integer aiWins;

    public Game() {
        this.gameName = "Rock Paper Scissors";
        this.hands = new ArrayList<>();
        this.userHand = null;
        this.aiHand = null;
        this.winnerName = null;
        this.winningHand = null;
        this.gameWon = false;
        this.userWins = 0;
        this.aiWins = 0;

        generateHands();
    }


    // getters

    public Integer getHandSize(){
        return hands.size();
    }

    public Hand getUserHand() {
        return userHand;
    }

    public Hand getAiHand() {
        return aiHand;
    }

    public Hand getHandByIndex(Integer index){
        return hands.get(index);
    }

    public boolean getGameWon() {
        return gameWon;
    }

    public Integer getUserWins() {
        return userWins;
    }

    public Integer getAiWins() {
        return aiWins;
    }


    // setters

    public void setUserHand(Hand userHand) {
        this.userHand = userHand;
    }

    public void setAiHand() {
        this.aiHand = getHandByIndex(generateRandom());
    }


    // other behaviour

    public void generateHands(){
        for (Hand hand : Hand.values()){
            hands.add(hand);
        }
    }

    public Integer generateRandom(){
        Random rand = new Random();
        return rand.nextInt(getHandSize());
    }

    public boolean checkWin(){
        if (userHand.getBeats() == aiHand.getName()){
            this.gameWon = true;
            this.winnerName = "You";
            this.winningHand = userHand;
            this.userWins++;
        } else if (aiHand.getBeats() == userHand.getName()) {
            this.gameWon = true;
            this.winnerName = "The Robot";
            this.winningHand = aiHand;
            this.aiWins++;
        }
        return this.gameWon;
    }

    public String play(Hand userHand){
        // set hands
        setUserHand(userHand);
        setAiHand();

        // compare hands
        checkWin();

        // assess/report win
        if (!this.gameWon){
            // draw scenario
            return "The game was a draw.";
        } else {
            // declare winner
            return this.winnerName + " won with " + winningHand.getName() + "!";
        }
    }

}
