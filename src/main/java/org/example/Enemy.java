package org.example;

import java.io.Serializable;

public class Enemy implements Serializable {

    int hp;
    int power;
    String name;
    boolean isAlive;
    String examineText;

    //Constructors

    public Enemy(){
        this.hp = 1;
        this.power = 1;
        this.name = "The Once";
        this.isAlive = true;
        this.examineText = "This being shouldn't exist";
    }
    public Enemy(String name){
        this.name = name;
        this.hp = 5;
        this.power = 2;
        this.isAlive = true;
    }
    public Enemy(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.power = 3;
        this.isAlive = true;
    }


    //Behaviors
    public void hurt(int damage){
        this.setHp(this.hp - damage);
        if(this.hp <= 0){
            this.setAlive(false);
            System.out.println(this.getName() + " has been defeated!");
        }
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getExamineText() {
        return examineText;
    }

    public void setExamineText(String examineText) {
        this.examineText = examineText;
    }
}
