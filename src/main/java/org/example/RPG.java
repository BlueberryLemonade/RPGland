package org.example;

import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {



        RPG main = new RPG();
        main.game();


    }

    public void game(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Character Name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName, 10);
        player.say("What's up?");


    }

}