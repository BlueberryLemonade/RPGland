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
            if (currentEnemy == null) {
                currentEnemy = createEnemy();
                System.out.println("A " + currentEnemy.getName() + " has appeared");

            }
            System.out.println("What would you like to do?");
            System.out.println("1 for attack 2 for attack strongly");
            int decision = input.nextInt();
            switch(decision){
                case 1: System.out.println("Regular attack");
                    fight(player, currentEnemy);
                    break;
                case 2: strongFight(player, currentEnemy);
                    break;
            }
        }while(player.health > 0);
    }


    public void fight(Player player, Enemy enemy){
        player.hurt(enemy.power);
        System.out.println(enemy.name + " attacked " + player.name + " for " + enemy.power + " damage." );
        System.out.println(player.name + "Remaining health: " + player.health);
        System.out.println("--------------------------------------");
        enemy.hurt(player.getStrength());
        if(enemy.getHp() < 0){
            System.out.println(enemy.getName() + " has been defeated!");
            currentEnemy = null;

        } else {
            System.out.println(enemy.getName() + "'s health is " + enemy.hp + " after taking " + player.getStrength() + " damage");
        }
    }

    public void strongFight(Player player, Enemy enemy){

        System.out.println("Player health before attack: " + player.health);
        player.hurt(enemy.power);
        System.out.println("Player health after attack: " + player.health);
        enemy.hurt(5* player.getStrength());
    }

    public Enemy createEnemy(){
        Random randomPick = new Random();
        List<Enemy> enemies = new ArrayList<>();

        Enemy goblin = new Enemy("Goblin", 10);
        Enemy kobold = new Enemy("Kobold", 5);

        enemies.add(goblin);
        enemies.add(kobold);

        int selection = randomPick.nextInt(2);
        return enemies.get(selection);

    }


}
