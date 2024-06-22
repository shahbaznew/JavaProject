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
    private boolean checkWinner(int lastRow, int lastCol) { 
        return checkLine(lastRow, lastCol, 0, 1) ||
                checkLine(lastRow, lastCol, 1, 0) ||
                checkLine(lastRow, lastCol, 1, 1) ||
                checkLine(lastRow, lastCol, 1, -1);
    }
    private boolean checkLine(int startRow, int startCol, int dRow, int dCol) { 
        int count = 0;
        char token = grid[startRow][startCol]; 
        for (int i = -winLength + 1; i < winLength; i++) { 
            int row = startRow + i * dRow; 
            int col = startCol + i * dCol; 
            if(row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == token) { 
                count++; 
                if(count == winLength) { 
                    return true; 
                }
            }else { 
                count = 0; 
            }
        }
        return false; 
    }
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

        logger.info("Welcome to Connect Four"); 
        logger.info("Etner number of rows you would like:"); 
        int rows = scanner.nextInt(); 
        logger.info("Etner number of columns you would like:"); 
        int cols = scanner.nextInt(); 
        logger.info("Enter winning row length:"); 
        int winLength = scanner.nextInt(); 

        ConnectFour game = new ConnectFour(rows, cols, winLength); 
        game.displayGrid();

        boolean winner = false; 
        

    }

















}