package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    ArrayList<Enemy> enemiesToFight = new ArrayList<>();

    public void run(){
        Player stan = new Player("Stan", 100,2);
        run(stan);
    }

    public void run(Player player){
        Scanner input = new Scanner(System.in);
        ArrayList enemies = new ArrayList<>();
        ArrayList<Enemy> enemiesToFight = new ArrayList<>();

        System.out.println("It looks peaceful");
        //Loading in enemies from file
        EnemyData enemyInfo = new EnemyData();

        if (enemyInfo.loadEnemies() != null) {
            enemies = enemyInfo.loadEnemies();
            System.out.println("Found enemies");
        } else {
            System.out.println("No enemies found, create one: ");
            createEnemy();
        }

        //Checking if enemy is still alive, if not, generating a new enemy
        do {



            if(enemiesToFight.isEmpty()){
                Enemy newEnemy = randomEnemy(enemies);
                enemiesToFight.add(newEnemy);
                System.out.println("---------------------------------------------");
                System.out.println("A " + newEnemy.getName() + " has appeared");
                System.out.println("---------------------------------------------");
            }

            Enemy currentEnemy = enemiesToFight.get(0);






            //The combat system. A regular attack or a strong attack.
            System.out.println("What would you like to do?");
            System.out.println("1 for attack 2 for attack strongly 3 for examine enemy");
            int decision = input.nextInt();
            switch(decision){
                case 1:
                    System.out.println("Regular attack");
                    Fight fight = new Fight();
                    fight.fight(player, currentEnemy);
                    if(!currentEnemy.isAlive){
                        enemiesToFight.remove(0);
                    }
                    break;
                case 2:
                    System.out.println("Strong attack");
                    Fight strongFight = new Fight();
                    strongFight.fight(player,currentEnemy,5);
                    if(!currentEnemy.isAlive){
                        enemiesToFight.remove(0);
                    }
                    break;
                case 3:
                    System.out.println("Examine");
                    System.out.println(currentEnemy.getExamineText());
                    break;
            }
        } while(player.health > 0);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Enemy randomEnemy(ArrayList<Enemy> potentialEnemies){

        Random rand = new Random();
        if (potentialEnemies != null) {
          int selection = rand.nextInt(potentialEnemies.size());

          return potentialEnemies.get(selection);
      } else {
          return null;
      }
  }

    public void createEnemy(){
        EnemyCreator creation = new EnemyCreator();
        Enemy fresh = creation.creationEnemy();
        System.out.println("Named: " + fresh.getName());
        System.out.println("Examine: "+ fresh.getExamineText());
        EnemyData data = new EnemyData();
        data.saveEnemy(fresh);
    }




}
