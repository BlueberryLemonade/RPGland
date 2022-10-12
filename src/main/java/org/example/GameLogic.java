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
        ArrayList enemies = new ArrayList<>();

        System.out.println("It looks peaceful");
        EnemyData enemyInfo = new EnemyData();
        if (enemyInfo.loadEnemies() != null) {
            enemies = enemyInfo.loadEnemies();
            System.out.println("Found enemies");
        } else {
            System.out.println("No enemies found, create one: ");
            createEnemy();
        }

        do {
            if(currentEnemy != null && !currentEnemy.isAlive){
                currentEnemy = null;
            }
            if (currentEnemy == null) {
                currentEnemy = randomEnemy(enemies);
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

    public void strongFight(Player player, Enemy enemy){

        int strongDamage = 5 * player.getStrength();
        System.out.println("Player health before attack: " + player.getHealth());
        player.hurt(enemy.getPower());
        System.out.println("Player health after attack: " + player.getHealth());
        System.out.println("You deal " + strongDamage + " damage to " + enemy.getName());
        enemy.hurt(strongDamage);

    }

  public Enemy randomEnemy(ArrayList<Enemy> potentialEnemies){

        Random rand = new Random();
        int selection = rand.nextInt(potentialEnemies.size());

        return potentialEnemies.get(selection);

  }

    public void createEnemy(){
        EnemyCreator creation = new EnemyCreator();
        Enemy fresh = creation.creationEnemy();
        System.out.println(fresh.getExamineText());
    }




}
