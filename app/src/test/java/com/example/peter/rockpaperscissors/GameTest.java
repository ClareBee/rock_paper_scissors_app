package com.example.peter.rockpaperscissors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.example.peter.rockpaperscissors.Hand.PAPER;
import static com.example.peter.rockpaperscissors.Hand.ROCK;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;

/**
 * Created by Peter on 08/11/2017.
 */

public class GameTest {

    Game game;
//    Game spyGame;

    @Before
    public void before(){
        game = new Game();
//        spyGame = spy(game);
    }

    @Test
    public void gameHasHands(){
        assertNotNull(game.getHandSize());
    }

    @Test
    public void gameStartsNotWon(){
        assertEquals(false, game.getGameWon());
    }

    @Test
    public void canGetHandByIndex(){
        game.setAiHand();

        assertNotNull(game.getAiHand());
    }

    @Test
    public void playerHasHand(){
        game.setUserHand(ROCK);

        assertEquals(ROCK, game.getUserHand());
    }

    @Test
    public void AIHasHand(){
        game.setAiHand();

        assertNotNull(game.getAiHand());
    }

    @Test
    public void hasWinner(){
        assertNotNull(game.play(Hand.ROCK));
    }

    @Test
    public void userStartsWithNoWins(){
        Integer wins = 0;
        assertEquals(wins, game.getUserWins());
    }

    @Test
    public void aiStartsWithNoWins(){
        Integer wins = 0;
        assertEquals(wins, game.getAiWins());
    }
}
