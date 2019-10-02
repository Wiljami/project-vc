package fi.tuni.tiko;

import java.util.Scanner;

public class SecretSnake {
    char[][] board = new char[20][20];
    int rows = board.length;
    int colls = board[0].length;
    Scanner scan = new Scanner(System.in);
    private int snakeHeadRows;
    private int snakeHeadColls;
    boolean keepMoving = true;

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
    public int getSnakeHeadColls() {
        return snakeHeadColls;
    }

    /**
     * @param snakeHeadCols the snakeHeadCols to set
     */
    public void setSnakeHeadColls(int snakeHeadCols) {
        this.snakeHeadColls = snakeHeadCols;
    }

    public void startSnake() {
        createBoard();
        generateFirstSnake();
        spawnApples();
        printBoard();
        keepMoving();
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
            setSnakeHeadColls(collsPlace);
            setSnakeHeadRows(rowsPlace);
        } else {
            generateFirstSnake();
        }
    }

    public void move() {
        System.out.println("Move snake: (wasd)");
        char move = scan.nextLine().charAt(0);

        switch (move) {
            case 'w':
                if(board[getSnakeHeadRows()-1][getSnakeHeadColls()] == ' ' || board[getSnakeHeadRows()-1][getSnakeHeadColls()] == '@' ) {
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = ' ';
                    setSnakeHeadRows(getSnakeHeadRows()-1);
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = 'S';
                } else {
                    keepMoving = false;
                }
            break;

            case 'a':
                if(board[getSnakeHeadRows()][getSnakeHeadColls()-1] == ' ' || board[getSnakeHeadRows()][getSnakeHeadColls()-1] == '@' ) {
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = ' ';
                    setSnakeHeadColls(getSnakeHeadColls()-1);
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = 'S';
                } else {
                    keepMoving = false;
                }
            break;

            case 's':
                if(board[getSnakeHeadRows()+1][getSnakeHeadColls()] == ' ' || board[getSnakeHeadRows()+1][getSnakeHeadColls()] == '@' ) {
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = ' ';
                    setSnakeHeadRows(getSnakeHeadRows()+1);
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = 'S';
                } else {
                    keepMoving = false;
                }
            break;

            case 'd':
                if(board[getSnakeHeadRows()][getSnakeHeadColls()+1] == ' ' || board[getSnakeHeadRows()][getSnakeHeadColls()+1] == '@' ) {
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = ' ';
                    setSnakeHeadColls(getSnakeHeadColls()+1);
                    board[getSnakeHeadRows()][getSnakeHeadColls()] = 'S';
                } else {
                    keepMoving = false;
                }
            break;
        }
    }

    public void keepMoving() {
        while(keepMoving) {
            move();
            printBoard();
        }
    }

    public void eatApple(){

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