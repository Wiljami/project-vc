package fi.tuni.tiko;

import java.util.Scanner;

public class SecretSnake {
    char[][] board = new char[20][20];
    int rows = board.length;
    int colls = board[0].length;
    Scanner scan = new Scanner(System.in);
    private int snakeHeadRows;
    private int snakeHeadCols;

    public SecretSnake() {
        
    }

    /**
     * @return the snakeHeadRows
     */
    public int getSnakeHeadRows() {
        return snakeHeadRows;
    }

    /**
     * @param snakeHeadRows the snakeHeadRows to set
     */
    public void setSnakeHeadRows(int snakeHeadRows) {
        this.snakeHeadRows = snakeHeadRows;
    }

    /**
     * @return the snakeHeadCols
     */
    public int getSnakeHeadCols() {
        return snakeHeadCols;
    }

    /**
     * @param snakeHeadCols the snakeHeadCols to set
     */
    public void setSnakeHeadCols(int snakeHeadCols) {
        this.snakeHeadCols = snakeHeadCols;
    }
    
    public void startSnake() {
        createBoard();
        generateFirstSnake();
        spawnApples();
        printBoard();
    }

    public void createBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j  <colls; j++) {
                if(i==0 || j == 0 || i == rows-1|| j == colls-1){
                    board[i][j] = '*';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public void generateFirstSnake() {
        int rowsPlace = randomGenerator(0, rows-1);
        int collsPlace = randomGenerator(0, colls-1);
        if(board[rowsPlace][collsPlace] == ' '){
            board[rowsPlace][collsPlace] = 'S';
        } else {
            generateFirstSnake();
        }
    }

    public void move() {

    }

    public void spawnApples() {
        int rowsPlace = randomGenerator(0, rows-1);
        int collsPlace = randomGenerator(0, colls-1);
        if(board[rowsPlace][collsPlace] == ' '){
            board[rowsPlace][collsPlace] = '@';
        } else {
            spawnApples();
        }
    }

    public int randomGenerator(int min, int max) {
        int random = (int) ((Math.random()*((max-min)+1))+min);
        return random;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j  <colls; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}