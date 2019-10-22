package fi.tuni.tiko;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * SecretSnake is used to play the snake game. 
 * 
 * It collects all of the snakepart and enemypart information and uses 
 * it to generate a board for the command prompt play. 
 * The game can only be played in command prompt.
 * 
 * @author Hanna Tuominen
 */

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

    /**
     * Generates the very first snake by getting two random numbers for colls and rows for the board and then creating a snake
     * in both the snakePartArray and the board array for use.
     * It generates new randoms until it finds an appropriate place to set the first snake part.
     */
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

    /**
     * Used to update the board array after each move.
     * First it checks the snakePartList and compares it to the board and updates it correctly with the snake parts.
     * Then it does the same for the enemies list. 
     */
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

    /**
     * Each turn the user gets asked first the direction (wasd) until they give an approppriate answer.
     * Then depending what the user has picked the snake moves itself to that direction one position (the snake head)
     * and checks where it would land. If it would land to anywhere that is not a wall it continues with the movement and checks where it lands
     * If it lands to an apple it eats it.
     * Each of the SnakePart that are in the arraylist gets moved to the last position that was recorded in the one before them.
     * After the movement the game updates the board array and then each of the snake parts old place in the list is updated to the new place for next round.
     */
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
        int rowsOld = snakePartList.get(SnakePartMaxID).getSnakePartRowsOld();
        int collsOld = snakePartList.get(SnakePartMaxID).getSnakePartCollsOld();

        snakePartList.add(new SnakePart(rowsOld, collsOld, SnakePartMaxID));
        board[rowsOld][collsOld] = 'S';
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

    /**
     * Used to move the enemy depending on where the enemy was before and it's new place.
     * It gets a random number between 0 and 3 and assigns (wasd) to match each number.
     * After getting a random number the method checks if the wanted direction either has an empty space or a snake part and moves it accordingly.
     */
    public void moveEnemy() {
        int moveDirection = randomGenerator(0, 3);
        int enemyAmount = snakeEnemyPartList.size();
        for(int i = 0; i < enemyAmount; i++) {

            int rowsNew = snakeEnemyPartList.get(i).getSnakeEnemyPartRowsNew();
            int collsNew = snakeEnemyPartList.get(i).getSnakeEnemyPartCollsNew();

            switch (moveDirection) {
                case 0:
                    if(board[rowsNew-1][collsNew] == 'S'){
                        keepMoving = false;
                        System.out.println("ENEMY HAS EATEN YOU!");
                    }
                    else if(board[rowsNew-1][collsNew] == ' '){
                        snakeEnemyPartList.get(i).moveEnemy('w');
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
                    snakeEnemyPartList.get(i).moveEnemy('a');
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
                    snakeEnemyPartList.get(i).moveEnemy('s');
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
                    snakeEnemyPartList.get(i).moveEnemy('d');
                }else {
                    moveEnemy();
                }
        
                break;
            }
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