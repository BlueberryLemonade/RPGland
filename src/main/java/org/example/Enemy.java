package org.example;

public class Enemy {

    int hp;
    int power;
    String name;

    //Constructors
    public Enemy(String name){
        this.name = name;
        this.hp = 10;
        this.power = 3;
    }
    public Enemy(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.power = 3;
    }

    //Behaviors
    public void hurt(int damage){
        this.hp = this.hp - damage;
    }



    //Getters and Setters
    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
