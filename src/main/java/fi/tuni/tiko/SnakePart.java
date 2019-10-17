package fi.tuni.tiko;

class SnakePart {
    //The placement (rows) that gets updated and is the new after each move of the snake in the board.
    private int snakePartRowsNew;
    //The placement (colls) that gets updated and is the new after each move of the snake in the board.
    private int snakePartCollsNew;
    //The placement (Rows) that is gotten from the SnakePartRowsNew each time before that one gets updated to save it for later use on another part.
    private int snakePartRowsOld;
    //The placement (Colls) that is gotten from the SnakePartCollsNew each time before that one gets updated to save it for later use on another part.
    private int snakePartCollsOld;
    //The id of the snake part.
    private int id;

    /**
     * Constructor to create a snake part object with a rows and colls place for placement
     * @param snakePartRowsNew the snakes rows place in the board
     * @param snakePartCollsNew the snakes colls place in the board
     * @param id the id of the snake
     */
    public SnakePart(int snakePartRowsNew, int snakePartCollsNew, int id) {
        setSnakePartCollsNew(snakePartCollsNew);
        setSnakePartRowsNew(snakePartRowsNew);
        setSnakePartCollsOld(snakePartCollsNew);
        setSnakePartRowsOld(snakePartRowsNew);
        setId(id);
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
     * @return the snakePartCollsNew
     */
    public int getSnakePartCollsNew() {
        return snakePartCollsNew;
    }
    /**
     * @param snakePartCollsNew the snakePartCollsNew to set
     */
    public void setSnakePartCollsNew(int snakePartCollsNew) {
        this.snakePartCollsNew = snakePartCollsNew;
    }

    /**
     * @return the snakePartCollsOld
     */
    public int getSnakePartCollsOld() {
        return snakePartCollsOld;
    }

    /**
     * @param snakePartCollsOld the snakePartCollsOld to set
     */
    public void setSnakePartCollsOld(int snakePartCollsOld) {
        this.snakePartCollsOld = snakePartCollsOld;
    }

    /**
     * @return the snakePartRowsNew
     */
    public int getSnakePartRowsNew() {
        return snakePartRowsNew;
    }

    /**
     * @param snakePartRowsNew the snakePartRowsNew to set
     */
    public void setSnakePartRowsNew(int snakePartRowsNew) {
        this.snakePartRowsNew = snakePartRowsNew;
    }

    /**
     * @return the snakePartRowsOld
     */
    public int getSnakePartRowsOld() {
        return snakePartRowsOld;
    }

    /**
     * @param snakePartRowsOld the snakePartRowsOld to set
     */
    public void setSnakePartRowsOld(int snakePartRowsOld) {
        this.snakePartRowsOld = snakePartRowsOld;
    }

    /**
     * Used to move the snake part to a new place. Not in use currently
     * @param move the move direction where to move the snake part.
     */
    public void movePartToNewPlace(char move) {
        switch (move) {
            case 'w':
                setSnakePartRowsNew(getSnakePartRowsNew()-1);
            break;

            case 'a':
                setSnakePartCollsNew(getSnakePartCollsNew()-1);
            break;

            case 's':
                setSnakePartRowsNew(getSnakePartRowsNew()+1);
            break;

            case 'd':
                setSnakePartCollsNew(getSnakePartCollsNew()+1);
            break;
        }
    }
    /**
     * Used to update the snakes oldPlace places with the old newPlace places (done before the new place gets updated.)
     */
    public void updateOldPlace() {
        setSnakePartCollsOld(getSnakePartCollsNew());
        setSnakePartRowsOld(getSnakePartRowsNew());
    }
}