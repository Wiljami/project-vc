package fi.tuni.tiko;

public class SecretSnake {
    char[][] board = new char[20][20];
    int rows = board.length;
    int colls = board[0].length;

    public SecretSnake() {
        
    }

    public void startSnake() {
        createBoard();
        printBoard();
    }

    public void createBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j  <colls; j++) {
                if(i==0 || j == 0 || i == rows-1|| j == colls-1){
                    board[i][j] = '*';
                }
            }
        }
    }

    public int randomGenerator() {
        return 0;
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