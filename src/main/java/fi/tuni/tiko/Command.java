package fi.tuni.tiko;
abstract class Command {
    private String[] str;
    private String desc;
    public Command(String[] str, String desc) {
        setStr(str);
        setDesc(desc);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    abstract void run();
}