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
    @Test 
    public void testVerticalWin() { 
        ConnectFour game = new ConnectFour(6, 7, 4); 
        game.addToken(0);
        game.addToken(1);
        game.addToken(0);
        game.addToken(1);
        game.addToken(0);
        game.addToken(1);
        boolean winner = game.addToken(0); 
        assertTrue("Expected Vertical win", winner); 
    }
    @Test 
    public void testDiagonalWin1() { 
        ConnectFour game = new ConnectFour(6, 7, 4); 
        game.addToken(0);
        game.addToken(1);
        game.addToken(1);
        game.addToken(2);
        game.addToken(2);
        game.addToken(3);
        game.addToken(2);
        game.addToken(3);
        game.addToken(3);
        game.addToken(4);
        boolean winner = game.addToken(3); 
        assertTrue("Expected Diagonal win", winner); 
    }
    @Test 
    public void testDiagonalWin2() { 
        ConnectFour game = new ConnectFour(6, 7, 4); 
        game.addToken(3);
        game.addToken(2);
        game.addToken(2);
        game.addToken(1);
        game.addToken(1);
        game.addToken(0);
        game.addToken(1);
        game.addToken(0);
        game.addToken(0);
        game.addToken(0);
        boolean winner = game.addToken(0); 
        assertTrue("Expected Diagonal win", winner); 
    }
    @Test 
    public void testInvalidColumn() { 
        ConnectFour game = new ConnectFour(6, 7, 4); 
        assertFalse("Expected invalid column", game.addToken(-1)); 
        assertFalse("Expected invalid column", game.addToken(7)); 
        
    }
    @Test 
    public void testFullColumn() { 
        ConnectFour game = new Connectfour(6, 7, 4); 
        for (int i =0; i < 6; i++ ){ 
            game.addToken(0);
        }
        assertFalse("Expected full column", game.addToken(0)); 
    }
}
