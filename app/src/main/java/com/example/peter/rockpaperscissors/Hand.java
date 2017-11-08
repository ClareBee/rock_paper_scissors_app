package com.example.peter.rockpaperscissors;

/**
 * Created by Peter on 08/11/2017.
 */

public enum Hand {

    ROCK("rock", "scissors"),
    PAPER("paper", "rock"),
    SCISSORS("scissors", "paper");

    private String name;
    private String beats;

    Hand(String name, String beats) {
        this.name = name;
        this.beats = beats;
    }

    public String getName() {
        return name;
    }

    public String getBeats() {
        return beats;
    }

}
