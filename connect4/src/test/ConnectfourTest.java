package com.example; 

import org.junit.Test; 
import static org.junit.Assert.*;

public class ConnectfourTest {
    @Test 
    public void testHorizontalWin() { 
        ConnectFour game = new ConnectFour(6, 7, 4); 
        game.addToken(0);
        game.addToken(0);
        game.addToken(1);
        game.addToken(1);
        game.addToken(2);
        game.addToken(2);
        boolean winner = game.addToken(3); 
        assertTrue("Expected horizontal win", winner); 
    }
}
