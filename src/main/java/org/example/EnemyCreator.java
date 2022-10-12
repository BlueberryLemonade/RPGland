package org.example;

import java.util.Scanner;

public class EnemyCreator {

    public Enemy creationEnemy(){
        String name;
        int power;
        int hp;
        String examineText;

        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to name it?");
        name = in.nextLine();
        System.out.println("How strong would you like to make it?");
        power = in.nextInt();
        System.out.println("How much hp?");
        hp = in.nextInt();
        System.out.println("Examine text?");
        examineText = in.nextLine();

        Enemy enemy = new Enemy(name, hp);
        enemy.setPower(power);
        enemy.setExamineText(examineText);

        return enemy;
    }
}
