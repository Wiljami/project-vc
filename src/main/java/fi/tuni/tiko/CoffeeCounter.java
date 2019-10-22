package fi.tuni.tiko;

import java.util.Scanner;

public class CoffeeCounter {
    int enoughCoffee = 10;
    int tooMuchCoffee = 15;

    public CoffeeCounter() {
        askAboutCoffee();
    }

    public void askAboutCoffee() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many cups of coffee have you drunk so far today?");
        int amount = Integer.parseInt(null, scan.nextInt());

        if(amount <= enoughCoffee) {
            System.out.println("Not enough coffee, you can drink more!");
        } else if (amount >= tooMuchCoffee) {
            System.out.println("Enough coffee, you can drink more, but maaaaaayyybe you should not, your choice tho!");
        }
    }
}