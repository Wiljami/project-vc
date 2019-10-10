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


    public void moveEnemy(char move) {
        switch (move) {
            case 'w':
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew()-1);
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew());
                System.out.println(getSnakeEnemyPartRowsNew() + "old" + getSnakeEnemyPartRowsOld());
            break;

            case 'a':
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew()-1);
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew());
                System.out.println(getSnakeEnemyPartCollsNew() + "old" + getSnakeEnemyPartCollsOld());
            break;

            case 's':
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew()+1);
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew());
                System.out.println(getSnakeEnemyPartRowsNew() + "old" + getSnakeEnemyPartRowsOld());
            break;

            case 'd':
                setSnakeEnemyPartCollsOld(getSnakeEnemyPartCollsNew());
                setSnakeEnemyPartCollsNew(getSnakeEnemyPartCollsNew()+1);
                setSnakeEnemyPartRowsOld(getSnakeEnemyPartRowsNew());
                setSnakeEnemyPartRowsNew(getSnakeEnemyPartRowsNew());
                System.out.println(getSnakeEnemyPartCollsNew() + "old" + getSnakeEnemyPartCollsOld());
            break;
        }
    }
}