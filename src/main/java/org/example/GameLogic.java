package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {



    Enemy currentEnemy = null;


    public void run(){
        Player stan = new Player("Stan", 100,2);
        run(stan);
    }

    public void run(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println("It looks peaceful");

        do {
            if(currentEnemy != null && !currentEnemy.isAlive){
                currentEnemy = null;
            }
            if (currentEnemy == null) {
                currentEnemy = createEnemy();
                System.out.println("---------------------------------------------");
                System.out.println("A " + currentEnemy.getName() + " has appeared");
                System.out.println("---------------------------------------------");

            }
            System.out.println("What would you like to do?");
            System.out.println("1 for attack 2 for attack strongly 3 for examine enemy");
            int decision = input.nextInt();
            switch(decision){
                case 1:
                    System.out.println("Regular attack");
                    Fight fight = new Fight(player, currentEnemy);
                    break;
                case 2:
                    System.out.println("Strong attack");
                    strongFight(player, currentEnemy);
                    break;
                case 3:
                    System.out.println("Examine");
                    System.out.println(currentEnemy.getExamineText());
                    break;
            }
        } while(player.health > 0);
    }

    //Combat between a player and an enemy with a combat log output
    public void fight(Player player, Enemy enemy){

        player.hurt(enemy.getPower());
        System.out.println(enemy.getName() + " attacked " + player.getName() + " for " + enemy.getPower() + " damage." );
        System.out.println(player.getName() + " remaining health: " + player.getHealth() + "\n");
        enemy.hurt(player.getStrength());
        //Checks to see if they survive before displaying the remaining health
        if(!enemy.isAlive){
            currentEnemy = null;
        } else {
            System.out.println(enemy.getName() + "'s health is " + enemy.getHp() + " after taking " + player.getStrength() + " damage");
        }
    }

    public void strongFight(Player player, Enemy enemy){

        int strongDamage = 5 * player.getStrength();
        System.out.println("Player health before attack: " + player.getHealth());
        player.hurt(enemy.getPower());
        System.out.println("Player health after attack: " + player.getHealth());
        System.out.println("You deal " + strongDamage + " damage to " + enemy.getName());
        enemy.hurt(strongDamage);

    }

    public Enemy createEnemy(){
        Random randomPick = new Random();
        List<Enemy> enemies = new ArrayList<>();

        Enemy goblin = new Enemy("Goblin", 10);
        Enemy kobold = new Enemy("Kobold", 5);
        Enemy once = new Enemy();

        goblin.setExamineText("A cranky goblin");
        kobold.setExamineText("Koboldy");
        enemies.add(goblin);
        enemies.add(kobold);
        enemies.add(once);

        int selection = randomPick.nextInt(2);
        return enemies.get(selection);

    }


}
