package fi.tuni.tiko;

/**
 * Abstract class Command holds info and functionality of a console command.
 * 
 * Command is a class that holds various information of a command, such as
 * its description and various Strings that can be used to call it.
 * 
 * @author Viljami Pietarila
 * @version 20191019
 */
abstract class Command {
    /**
     * Various Strings that are the written command words for this Command
     */
    private String[] str;

    /**
     * String description of the command in question
     */
    private String desc;

    /**
     * Command constructor
     * @param str String array of various commands
     * @param desc String description of the command
     */
    public Command(String[] str, String desc) {
        setStr(str);
        setDesc(desc);
    }

    /**
     * Getter for Desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter for Desc
     * @param desc Desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for array of String
     * @return array of commands
     */
    public String[] getStr() {
        return str;
    }

    /**
     * Setter for array of commands
     * @param str Array of commands
     */
    public void setStr(String[] str) {
        this.str = str;
    }

    /**
     * Abstract run method. This is the method that is run when the matching command is given.
     */
    abstract void run();
}