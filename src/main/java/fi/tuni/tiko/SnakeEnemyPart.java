package fi.tuni.tiko;

class SnakeEnemyPart {
    int snakeEnemyPartRowsNew;
    int snakeEnemyPartCollsNew;
    int snakeEnemyPartCollsOld;
    int snakeEnemyPartRowsOld;
    int id;

    public SnakeEnemyPart(int snakeEnemyPartRowsNew, int snakeEnemyPartCollsNew, int id) {
        setSnakeEnemyPartCollsNew(snakeEnemyPartCollsNew);
        setSnakeEnemyPartRowsNew(snakeEnemyPartRowsNew);
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
    

    public void moveEnemy(char move) {
        switch (move) {
            case 'w':
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew()-1);
            break;

            case 'a':
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew()-1);
            break;

            case 's':
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew()+1);
            break;

            case 'd':
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew()+1);
            break;
        }
    }
}