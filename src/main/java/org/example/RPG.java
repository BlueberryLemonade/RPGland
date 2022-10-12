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

        GameLogic controller = new GameLogic();

        Enemy currentEnemy = null;
        System.out.println("It looks peaceful");

        do {
            if (currentEnemy == null) {
                currentEnemy = controller.createEnemy();
                System.out.println("A " + currentEnemy.getName() + " has appeared");

            }
            System.out.println("What would you like to do?");
            System.out.println("1 for attack 2 for attack strongly");
            int decision = input.nextInt();
            switch(decision){
                case 1: System.out.println("Regular attack");
                    controller.fight(player, currentEnemy);
                case 2: controller.strongFight(player, currentEnemy);

            }
        }while(player.health > 0);











    }



}