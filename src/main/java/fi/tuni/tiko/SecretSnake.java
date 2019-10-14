package fi.tuni.tiko;

import java.util.ArrayList;
import java.util.Scanner;

public class SecretSnake {
    char[][] board = new char[20][20];
    ArrayList<SnakePart> snakePartList = new ArrayList<SnakePart>();
    ArrayList<SnakeEnemyPart> snakeEnemyPartList = new ArrayList<SnakeEnemyPart>();

    int rows = board.length;
    int colls = board[0].length;
    Scanner scan = new Scanner(System.in);
    private int snakeHeadRows;
    private int snakeHeadColls;
    int appleCount = 0;
    boolean keepMoving = true;
    int SnakePartMaxID = 0;
    int enemyId = 0;

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

    /**
     * Used to start (initialize) the snake board game.
     * 
     * Calls all of the needed methods to start the game.
     */
    public void startSnake() {
        createBoard();
        generateFirstSnake();
        generateEnemy();
        spawnApples();
        printBoard();
        keepMoving();
    }

    /**
     * Creates the board initially and fills it with * for borders and spaces for empty spaces accross the board.
     */
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
        
        for (SnakeEnemyPart e : snakeEnemyPartList) {
            board[e.getSnakeEnemyPartRowsOld()][e.getSnakeEnemyPartCollsOld()] = ' ';
            board[e.getSnakeEnemyPartRowsNew()][e.getSnakeEnemyPartCollsNew()] = 'E';
        }
    }

    public void move() {
        char move;

        do {
            System.out.println("Move snake: (wasd)");
            move = scan.nextLine().charAt(0);
        } while(move != 'a' && move != 'w' && move != 's' && move != 'd');
        

        switch (move) {
            case 'w':
                if(board[snakePartList.get(0).getSnakePartRowsOld()-1][snakePartList.get(0).getSnakePartCollsOld()] != '*' ) {
                    if(board[snakePartList.get(0).getSnakePartRowsOld()-1][snakePartList.get(0).getSnakePartCollsOld()] == '@') {
                        eatApple();
                    }

                    if(board[snakePartList.get(0).getSnakePartRowsOld()-1][snakePartList.get(0).getSnakePartCollsOld()] == 'S') {
                        keepMoving = false;
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
                        snakePartList.get(i).updateOldPlace();
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
                    if( board[snakePartList.get(0).getSnakePartRowsOld()][snakePartList.get(0).getSnakePartCollsOld()-1] == 'S') {
                        keepMoving = false;
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
                        snakePartList.get(i).updateOldPlace();
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
                    if( board[snakePartList.get(0).getSnakePartRowsOld()+1][snakePartList.get(0).getSnakePartCollsOld()] == 'S') {
                        keepMoving = false;
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
                        snakePartList.get(i).updateOldPlace();
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
                    if(board[snakePartList.get(0).getSnakePartRowsOld()][snakePartList.get(0).getSnakePartCollsOld()+1] == 'S') {
                        keepMoving = false;
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
                        snakePartList.get(i).updateOldPlace();
                    }

                   
                } else {
                    keepMoving = false;
                }
            break;
        }
    }

    /**
     * Used to keep the game going until the keepMoving boolean is set to false.
     * 
     * Used to call the moveEnemy, move, and printBoard methods in a row until the game has been set to end.
     */
    public void keepMoving() {
        while(keepMoving) {
            moveEnemy();
            move();
            printBoard();
        }
        System.out.println("YOU HAVE DIED A TERRIBLE DEATH, FORSHAME.");
        System.out.println("YOUR FINAL SCORE OF APPLES WAS: " +appleCount + ". Congratulations!");
    }

    /**
     * Used to eat an apple (called from move class). The method adds a new snake part to the right placement in the array and to the board and gives +1 to the apple count.
     * It also spawns a new apple and checks if the applecount is high enough to generate a new board with the method.
     */
    public void eatApple(){
        System.out.println(snakePartList.get(SnakePartMaxID).getSnakePartRowsOld());
        snakePartList.add(new SnakePart(snakePartList.get(SnakePartMaxID).getSnakePartRowsOld(), snakePartList.get(SnakePartMaxID).getSnakePartCollsOld(), SnakePartMaxID));
        board[snakePartList.get(SnakePartMaxID).getSnakePartRowsOld()][snakePartList.get(SnakePartMaxID).getSnakePartCollsOld()] = 'S';
        SnakePartMaxID++;
        appleCount++;
        generateNewBoardAfterWin();
        spawnApples();
    }

    /**
     * Spawns apples to the gameboard.
     * 
     * Used to spawn apples to a random place on the gameboard.
     * Calls itself until it find a new empty place for an apple placement in the board char array.
     */
    public void spawnApples() {
        int rowsPlace = randomGenerator(0, rows-1);
        int collsPlace = randomGenerator(0, colls-1);
        if(board[rowsPlace][collsPlace] == ' '){
            board[rowsPlace][collsPlace] = '@';
        } else {
            spawnApples();
        }
    }

    /**
     * Generates a new enemy to the board and adds it to an enemy array.
     * 
     * Used to generate an enemy to the board char array and add a new snakeEnemyPart object to the snakeEnemyPartList.
     * Calls itself until it finds an empty place for the placement of the enemy and palces it in place on the board.
     */
    public void generateEnemy() {
        int rowsPlace = randomGenerator(0, rows-1);
        int collsPlace = randomGenerator(0, colls-1);

        if(board[rowsPlace][collsPlace] == ' '){
            snakeEnemyPartList.add(new SnakeEnemyPart(rowsPlace, collsPlace, enemyId));
            board[rowsPlace][collsPlace] = 'E';
            setSnakeHeadColls(collsPlace);
            setSnakeHeadRows(rowsPlace);
        } else {
            generateEnemy();
        }
    }

    public void moveEnemy() {
        int moveDirection = randomGenerator(0, 3);
        int rowsNew = snakeEnemyPartList.get(0).getSnakeEnemyPartRowsNew();
        int collsNew = snakeEnemyPartList.get(0).getSnakeEnemyPartCollsNew();

        switch (moveDirection) {
            case 0:
                if(board[rowsNew-1][collsNew] == 'S'){
                    keepMoving = false;
                    System.out.println("ENEMY HAS EATEN YOU!");
                }
                else if(board[rowsNew-1][collsNew] == ' '){
                    snakeEnemyPartList.get(0).moveEnemy('w');
                } else {
                    moveEnemy();
                }
            break;

            case 1:
            if(board[rowsNew][collsNew-1] == 'S'){
                keepMoving = false;
                System.out.println("ENEMY HAS EATEN YOU!");
            }
            else if(board[rowsNew][collsNew-1] == ' '){
                snakeEnemyPartList.get(0).moveEnemy('a');
            }else {
                moveEnemy();
            }

            break;

            case 2:
            if(board[rowsNew+1][collsNew] == 'S'){
                keepMoving = false;
                System.out.println("ENEMY HAS EATEN YOU!");
            }
            else if(board[rowsNew+1][collsNew] == ' '){
                snakeEnemyPartList.get(0).moveEnemy('s');
            }else {
                moveEnemy();
            }

            break;

            case 3:
            if(board[rowsNew][collsNew+1] == 'S'){
                keepMoving = false;
                System.out.println("ENEMY HAS EATEN YOU!");
            }
            else if(board[rowsNew][collsNew+1] == ' '){
                snakeEnemyPartList.get(0).moveEnemy('d');
            }else {
                moveEnemy();
            }
     
            break;
        }
    }

    /**
     * Used to generate a new board with a snake and enemy size of 1 every X amount of apples eaten.
     * 
     * After each applecount added the it checks if its big enough and then it either goes to the if or not.
     */
    public void generateNewBoardAfterWin() {
        if(appleCount % 15 == 0) {
            System.out.println("CONGRATULATIONS YOU HAVE PASSED THE MAGICAL NUMBER OF: " + appleCount);
            System.out.println("THIS MEANS YOU GET TO GO TO A NEW BOARD AND CONTINUE YOUR GAME - ENJOY!");
            snakePartList.clear();
            snakeEnemyPartList.clear();
            SnakePartMaxID = 0;
            startSnake();
        }
    }

    /**
     * Used to generate a random int number between the minimum and maximum numbers given and then return it.
     * @param min the minimum int number the random can be.
     * @param max the maximum int number the random can be.
     * @return a random in that was generated between the min and max ints.
     */
    public int randomGenerator(int min, int max) {
        int random = (int) ((Math.random()*((max-min)+1))+min);
        return random;
    }

    /**
     * Prints the gameboard whenever it is called.
     * 
     * Used to print the gameboard that is chars to the screen.
     */
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