package fi.tuni.tiko;

class SnakePart {
    private int snapePartRowsNew;
    private int snakePartCollsNew;
    private int snapePartRowsOld;
    private int snakePartCollsOld;
    private int id;

    public SnakePart(int snapePartRowsNew, int snakePartCollsNew, int id) {
        setSnakePartCollsNew(snakePartCollsNew);
        setSnapePartRowsNew(snapePartRowsNew);
        setSnakePartCollsOld(snakePartCollsNew);
        setSnapePartRowsOld(snapePartRowsNew);
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
     * @return the snapePartRowsNew
     */
    public int getSnapePartRowsNew() {
        return snapePartRowsNew;
    }

    /**
     * @param snapePartRowsNew the snapePartRowsNew to set
     */
    public void setSnapePartRowsNew(int snapePartRowsNew) {
        this.snapePartRowsNew = snapePartRowsNew;
    }

    /**
     * @return the snapePartRowsOld
     */
    public int getSnapePartRowsOld() {
        return snapePartRowsOld;
    }

    /**
     * @param snapePartRowsOld the snapePartRowsOld to set
     */
    public void setSnapePartRowsOld(int snapePartRowsOld) {
        this.snapePartRowsOld = snapePartRowsOld;
    }
}