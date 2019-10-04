package fi.tuni.tiko;

class SnakePart {
    private int snakePartRowsNew;
    private int snakePartCollsNew;
    private int snakePartRowsOld;
    private int snakePartCollsOld;
    private int id;

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
}