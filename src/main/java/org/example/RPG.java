package org.example;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class RPG extends Frame implements ActionListener {

    private Label textfield;
    private Button play;
    private Button quit;
    private Button createMon;

    public static void main(String[] args) {
        RPG main = new RPG();
        main.RPG();
        main.setVisible(true);
        main.setLocation(300,300);

    }

    public void RPG() {

        setLayout(new FlowLayout());

        textfield = new Label("Welcome to RPGland, the land in which there is an RPG." +
                "\n What would you like to do?" +
                "\n 1 -- New Game" +
                "\n 2 -- Quit" +
                "\n 3 -- Create an Enemy");
        add(textfield);

        play = new Button("Play");
        quit = new Button("Quit");

        add(play);
        add(quit);

        play.addActionListener(this);
        quit.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                dispose();
            }
        });

        setSize(800, 300);
        setTitle("RPG Land");





    }

    public void actionPerformed(ActionEvent action){

        if(action.getSource()==play){
            GameLogic controller = new GameLogic();
            controller.run();
        }
    }
}