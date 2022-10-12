package org.example;

public class Player {
    String name;
    int health;
    int strength;

    //Constructor
    public Player(int health){
        this.name = "Nameless";
        this.health = health;
        this.strength = 1;
    }
    public Player(String name, int health){
        this.name = name;
        this.health = health;
        this.strength = 1;
    }
    public Player(String name, int health, int strength){
        this.name = name;
        this.health = health;
        this.strength = strength;
    }
    //Behaviors
    public void say(String speech){
        System.out.println(this.name + ": " + speech);
    }

    public void attack(Enemy enemy){
        enemy.hp = enemy.hp - 1;
        System.out.println("Enemy hp is now " + enemy.hp);
    }





    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
