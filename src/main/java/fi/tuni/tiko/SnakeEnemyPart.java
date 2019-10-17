package fi.tuni.tiko;

class SnakeEnemyPart {
    int snakeEnemyPartRowsNew;
    int snakeEnemyPartCollsNew;
    int snakeEnemyPartCollsOld;
    int snakeEnemyPartRowsOld;
    int id;

    /**
     * Constructor to set all of the needed int attributes upon creation.
     * @param snakeEnemyPartRowsNew The place for the snake enemy part (Rows) in the board.
     * @param snakeEnemyPartCollsNew The place for the snake enemy part (Colls) in the board.
     * @param id the Id of the snake.
     */
    public SnakeEnemyPart(int snakeEnemyPartRowsNew, int snakeEnemyPartCollsNew, int id) {
        setSnakeEnemyPartCollsNew(snakeEnemyPartCollsNew);
        setSnakeEnemyPartRowsNew(snakeEnemyPartRowsNew);
        setSnakeEnemyPartCollsOld(snakeEnemyPartCollsNew);
        setSnakeEnemyPartRowsOld(snakeEnemyPartRowsNew);

        setId(id);
    }

    /**
     * @param snakeEnemyPartCollsNew the snakeEnemyPartCollsNew to set
     */
    public void setSnakeEnemyPartCollsNew(int snakeEnemyPartCollsNew) {
        this.snakeEnemyPartCollsNew = snakeEnemyPartCollsNew;
    }
    /**
     * @return the snakeEnemyPartCollsNew
     */
    public int getSnakeEnemyPartCollsNew() {
        return snakeEnemyPartCollsNew;
    }
    /**
     * @param snakeEnemyPartRowsNew the snakeEnemyPartRowsNew to set
     */
    public void setSnakeEnemyPartRowsNew(int snakeEnemyPartRowsNew) {
        this.snakeEnemyPartRowsNew = snakeEnemyPartRowsNew;
    }
    /**
     * @return the snakeEnemyPartRowsNew
     */
    public int getSnakeEnemyPartRowsNew() {
        return snakeEnemyPartRowsNew;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param snakeEnemyPartCollsOld the snakeEnemyPartCollsOld to set
     */
    public void setSnakeEnemyPartCollsOld(int snakeEnemyPartCollsOld) {
        this.snakeEnemyPartCollsOld = snakeEnemyPartCollsOld;
    }

    /**
     * @return the snakeEnemyPartCollsOld
     */
    public int getSnakeEnemyPartCollsOld() {
        return snakeEnemyPartCollsOld;
    }
    
    /**
     * @param snakeEnemyPartRowsOld the snakeEnemyPartRowsOld to set
     */
    public void setSnakeEnemyPartRowsOld(int snakeEnemyPartRowsOld) {
        this.snakeEnemyPartRowsOld = snakeEnemyPartRowsOld;
    }

    /**
     * @return the snakeEnemyPartRowsOld
     */
    public int getSnakeEnemyPartRowsOld() {
        return snakeEnemyPartRowsOld;
    }


    /**
     * Used to move the enemy placement in the board array eiher one up,down,left or right depending on the gotten char attribute.
     * @param move the attribute (wasd) decides which way the enemy should move to next. 
     */
    public void moveEnemy(char move) {
        switch (move) {
            case 'w':
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew()-1);
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew());
            break;

            case 'a':
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew()-1);
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew());
            break;

            case 's':
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew()+1);
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew());
            break;

            case 'd':
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew()+1);
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew());
            break;
        }
    }
}