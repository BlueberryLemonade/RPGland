package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {


    public void fight(Player player, Enemy enemy){
        player.setHealth(player.health - enemy.power);
        System.out.println(enemy.name + "attacked " + player.name + " for " + enemy.power + " damage." );
        System.out.println("Remaining health: " + player.health);
        enemy.setHp(enemy.hp - player.getStrength());
        System.out.println(enemy.getName() + "hp is " + enemy.hp + " after taking " + player.getStrength() + "damage");
    }

    public void strongFight(Player player, Enemy enemy){

        System.out.println(enemy.name + "attacked " + player.name + " for " + enemy.power + " damage." );
        System.out.println("Remaining health: " + player.health);
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
