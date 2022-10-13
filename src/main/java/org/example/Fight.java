package org.example;

public class Fight {


    public void fight(Player player, Enemy enemy){
        System.out.println(enemy.getName() + " deals " + enemy.getPower() + " damage to " + player.getName());
        player.hurt(enemy.getPower());
        System.out.println(player.getName() + " deals " + player.getStrength() + " damage to " + enemy.getName() );
        enemy.hurt(player.getStrength());
    }

    public void fight(Player player, Enemy enemy, int modifier){
        int damage = player.getStrength() * modifier;
        System.out.println(enemy.getName() + "deals " + enemy.getPower() + " damage to " + player.getName());
        player.hurt(enemy.getPower());
        System.out.println(player.getName() + " deals " + damage + " damage to " + enemy.getName());
        enemy.hurt(damage);

    }




}
