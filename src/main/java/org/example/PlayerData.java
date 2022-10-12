package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PlayerData implements Serializable {


    String PATH = "C:/Development/General/BasicRPG/data/warriors";

    public ArrayList<Enemy> loadEnemies(){

        try {
            FileInputStream fileIn = new FileInputStream(PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);



            ArrayList<Enemy> enemies =  (ArrayList<Enemy>) objIn.readObject();
            System.out.println("Loaded in" + enemies.size() + " enemies");
            objIn.close();

            return enemies;
        }catch (Exception ex ){
            ex.printStackTrace();
        }
        return null;
    }

    public void saveEnemies(List<Enemy> enemies){


        try {
            FileOutputStream fileOut = new FileOutputStream(PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(enemies);
            objOut.flush();
            objOut.close();
            System.out.println("The enemies were saved");


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
