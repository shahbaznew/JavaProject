package com.example;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectFour { 
    private static final Logger logger  = LoggerFactory.getLogger(ConnectFour.class)
    private final int rows; 
    private final int cols; 
    private final int winLength; 
    private final char[][] grid; 
    private char currentPlayer;

    public ConnectFour(int rows, int cols, int winLength) { 
        this.rows = rows; 
        this.cols = cols; 
        this.winLength = winLength;
        this.grid = new char[rows][cols]; 
        this.currentPlayer = 'R'; 
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) { 
                grid[i][j] = ' ';
            }
        }
    }
    public void displayGrid() { 
        for (char[] row : grid) { 
            StringBuilder rowDisplay = new StringBuilder("|"); 
            for (char cell : row) { 
                rowDisplay.append(cell).append("|"); 

            }
            logger.info(rowDisplay.toString());
        } 
        logger.info(repeat("-", cols * 2 + 1));
        StringBuilder colNumbers = new StringBuilder(); 
        for (int i = 0; i < cols; i++) { 
            colNumbers.append(i).append(" "); 
        }
        logger.info(colNumbers.toString());
    }
    public boolean addToken(int col) { 
        if (col < 0 || col >= cols) { 
            logger.error("invalid column"); 
            return false;
        }
        for (int row = rows - 1; row >= 0; row --){ 
            if(grid[row][col] == ' ') { 
                grid[row][col] = currentPlayer; 
                if(checkWinner(row, col)) { 
                    displayGrid();
                    logger.info("{} wins!", currentPlayer == 'R' ? "Red" : "Yellow"); 
                    return true;
                }
                currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
                return true; 
            }
        }
        logger.error("Column is full");
        return false; 
    }

















}