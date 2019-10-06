package fi.tuni.tiko;

import java.util.ArrayList;
import java.util.Scanner;

public class SecretSnake {
    char[][] board = new char[20][20];
    ArrayList<SnakePart> snakePartList = new ArrayList<SnakePart>();

    int rows = board.length;
    int colls = board[0].length;
    Scanner scan = new Scanner(System.in);
    private int snakeHeadRows;
    private int snakeHeadColls;
    int appleCount = 0;
    boolean keepMoving = true;
    int SnakePartMaxID = 0;

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
            snakePartList.add(new SnakePart(rowsPlace, collsPlace, SnakePartMaxID));
            board[rowsPlace][collsPlace] = 'S';
            setSnakeHeadColls(collsPlace);
            setSnakeHeadRows(rowsPlace);
        } else {
            generateFirstSnake();
        }
    }

    public void updateBoard() {
        for(SnakePart s : snakePartList) {
            board[s.getSnakePartRowsOld()][s.getSnakePartCollsOld()] = ' ';
            board[s.getSnakePartRowsNew()][s.getSnakePartCollsNew()] = 'S';
        }
    }

    public void move() {
        System.out.println("Move snake: (wasd)");
        char move = scan.nextLine().charAt(0);

        switch (move) {
            case 'w':
                if(board[snakePartList.get(0).getSnakePartRowsOld()-1][snakePartList.get(0).getSnakePartCollsOld()] != '*' ) {
                    if(board[snakePartList.get(0).getSnakePartRowsOld()-1][snakePartList.get(0).getSnakePartCollsOld()] == '@') {
                        eatApple();
                    }

                    for(int i = 0; i < snakePartList.size(); i++) {
                        if(i != 0) {
                            snakePartList.get(i).setSnakePartRowsNew(snakePartList.get(i-1).getSnakePartRowsOld());
                            snakePartList.get(i).setSnakePartCollsNew(snakePartList.get(i-1).getSnakePartCollsOld());
                        } else {
                            snakePartList.get(i).setSnakePartRowsNew(snakePartList.get(i).getSnakePartRowsOld()-1);
                        }
                        System.out.println( "RN: " + snakePartList.get(i).getSnakePartRowsNew() + "CN: " + snakePartList.get(i).getSnakePartCollsNew() + 
                        "RO: " + snakePartList.get(i).getSnakePartRowsOld() + "CO: " + snakePartList.get(i).getSnakePartCollsOld());
                    }

                    updateBoard();

                    for(int i = 0; i < snakePartList.size(); i++) {
                        snakePartList.get(i).setSnakePartRowsOld(snakePartList.get(i).getSnakePartRowsNew());
                        snakePartList.get(i).setSnakePartCollsOld(snakePartList.get(i).getSnakePartCollsNew());
                    }
                    
                    
                } else {
                    keepMoving = false;
                }
            break;

            case 'a':
                if(board[snakePartList.get(0).getSnakePartRowsOld()][snakePartList.get(0).getSnakePartCollsOld()-1] != '*' ) {
                    if( board[snakePartList.get(0).getSnakePartRowsOld()][snakePartList.get(0).getSnakePartCollsOld()-1] == '@') {
                        eatApple();
                    }
                    for(int i = 0; i < snakePartList.size(); i++) {
                        if(i != 0) {
                            snakePartList.get(i).setSnakePartCollsNew(snakePartList.get(i-1).getSnakePartCollsOld());
                            snakePartList.get(i).setSnakePartRowsNew(snakePartList.get(i-1).getSnakePartRowsOld());
                        } else {
                            snakePartList.get(i).setSnakePartCollsNew(snakePartList.get(i).getSnakePartCollsOld()-1);
                        }
                    }
                    updateBoard();

                    for(int i = 0; i < snakePartList.size(); i++) {
                        snakePartList.get(i).setSnakePartCollsOld(snakePartList.get(i).getSnakePartCollsNew());
                        snakePartList.get(i).setSnakePartRowsOld(snakePartList.get(i).getSnakePartRowsNew());
                    }

                   
                } else {
                    keepMoving = false;
                }
            break;

            case 's':
                if(board[snakePartList.get(0).getSnakePartRowsOld()+1][snakePartList.get(0).getSnakePartCollsOld()] != '*') {
                    if( board[snakePartList.get(0).getSnakePartRowsOld()+1][snakePartList.get(0).getSnakePartCollsOld()] == '@') {
                        eatApple();
                    }
                    for(int i = 0; i < snakePartList.size(); i++) {
                        if(i != 0) {
                            snakePartList.get(i).setSnakePartRowsNew(snakePartList.get(i-1).getSnakePartRowsOld());
                            snakePartList.get(i).setSnakePartCollsNew(snakePartList.get(i-1).getSnakePartCollsOld());
                        } else {
                            snakePartList.get(i).setSnakePartRowsNew(snakePartList.get(i).getSnakePartRowsOld()+1);
                        }
                    }
                    updateBoard();

                    for(int i = 0; i < snakePartList.size(); i++) {
                        snakePartList.get(i).setSnakePartRowsOld(snakePartList.get(i).getSnakePartRowsNew());
                        snakePartList.get(i).setSnakePartCollsOld(snakePartList.get(i).getSnakePartCollsNew());
                    }

                   
                } else {
                    keepMoving = false;
                }
            break;

            case 'd':
                if(board[snakePartList.get(0).getSnakePartRowsOld()][snakePartList.get(0).getSnakePartCollsOld()+1] != '*') {
                    if(board[snakePartList.get(0).getSnakePartRowsOld()][snakePartList.get(0).getSnakePartCollsOld()+1] == '@') {
                        eatApple();
                    }
                    for(int i = 0; i < snakePartList.size(); i++) {
                        if(i != 0) {
                            snakePartList.get(i).setSnakePartCollsNew(snakePartList.get(i-1).getSnakePartCollsOld());
                            snakePartList.get(i).setSnakePartRowsNew(snakePartList.get(i-1).getSnakePartRowsOld());
                        } else {
                            snakePartList.get(i).setSnakePartCollsNew(snakePartList.get(i).getSnakePartCollsOld()+1);
                        }
                    }
                    updateBoard();
                    
                    for(int i = 0; i < snakePartList.size(); i++) {
                        snakePartList.get(i).setSnakePartCollsOld(snakePartList.get(i).getSnakePartCollsNew());
                        snakePartList.get(i).setSnakePartRowsOld(snakePartList.get(i).getSnakePartRowsNew());
                    }

                   
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
        System.out.println(snakePartList.get(SnakePartMaxID).getSnakePartRowsOld());
        snakePartList.add(new SnakePart(snakePartList.get(SnakePartMaxID).getSnakePartRowsOld(), snakePartList.get(SnakePartMaxID).getSnakePartCollsOld(), SnakePartMaxID));
        board[snakePartList.get(SnakePartMaxID).getSnakePartRowsOld()][snakePartList.get(SnakePartMaxID).getSnakePartCollsOld()] = 'S';
        SnakePartMaxID++;
        spawnApples();
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
            if(i == 0) {
                System.out.print("   Apples eaten: " + appleCount);
            }
            System.out.println("");
        }
    }
}