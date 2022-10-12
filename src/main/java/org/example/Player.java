package org.example;

public class Player {
    String name;
    int health;

    //Constructor
    public Player(int health){
        this.name = "Nameless";
        this.health = health;
    }
    public Player(String name, int health){
        this.name = name;
        this.health = health;
    }
    //Behaviors
    public void say(String speech){
        System.out.println(this.name + ": " + speech);
    }






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
}
