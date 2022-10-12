package org.example;

import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        RPG main = new RPG();
        main.game();
    }

    public void game(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to RPGland, the land in which there is an RPG." +
                "\n What would you like to do?" +
                "\n 1 -- New Game" +
                "\n 2 -- Quit");

        int optionSelect = input.nextInt();



        GameLogic controller = new GameLogic();
        controller.run();

    }
}