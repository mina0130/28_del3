package main.java;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import java.util.*;
public class Monopoly {

    public static void main(String[] args) {

        GUI gui = new GUI();
        Scanner scanner = new Scanner(System.in);
        Die die = new Die();
        boolean lose=false; // bliver true når en spiller har tabt, dvs spillet er slut
        int PlayerTurn=1; //1,2,3 eller 4, afhængig af vis tur det er
        int sum, dice1throw, dice2throw, totalplayers, previousThrow=0;


        //her laver vi players
        System.out.println("input Number of Players");
        totalplayers= gui.getUserInteger("Input Number of Players");
        while(totalplayers<2 || totalplayers>4){
            System.out.println("Please input 2, 3, or 4 players");
            totalplayers=gui.getUserInteger("Please input 2, 3, or 4 players");
        }
        int[] currentField = new int [totalplayers];
        for(int i=0; i<totalplayers; i++){
            currentField[i]=0;
        }
        String[] playername = new String[totalplayers];
        gui_fields.GUI_Player[] player = new GUI_Player[totalplayers];
        int count=0;
        for(int i=0; i<totalplayers; i++){
            count++;
            playername[i]=gui.getUserString("Input the name of Player " + count);
           player[i]=new GUI_Player(playername[i]);
           gui.getFields()[0].setCar(player[i], true);
        }

            //deciding who starts
        gui.displayChanceCard("The user obtaining the highest sum will start");
            for(int i=0; i<totalplayers; i++){
                gui.getUserString(playername[i] + " press enter to roll dice");
                die.roll();
                dice1throw=die.getDice();
                die.roll();
                dice2throw=die.getDice();
            gui.setDice(dice1throw, dice2throw);
            sum=dice1throw+dice2throw;
            gui.displayChanceCard("the sum of your throw is " + sum);
            if(sum>previousThrow){
                PlayerTurn=i;
            }
            else if(sum==previousThrow){
                gui.displayChanceCard("Your throw equals another throw. Please roll again");
                i--;
            }
            previousThrow=sum;
            }

            // game flow starts here
        while(!lose){
            if(PlayerTurn>=totalplayers){
                PlayerTurn=0;
            }
            gui.getUserString(playername[PlayerTurn] + " press enter to roll dice");
                die.roll();
                dice1throw=die.getDice();
                die.roll();
                dice2throw=die.getDice();
                gui.setDice(dice1throw, dice2throw);
                sum=dice1throw+dice2throw;
                gui.displayChanceCard("the sum of your throw is " + sum);
            gui.getFields()[currentField[PlayerTurn]].removeAllCars();

                while(currentField[PlayerTurn]<16 && sum!=0){
                    if(currentField[PlayerTurn]==15){
                        currentField[PlayerTurn]=0;
                    }
                    currentField[PlayerTurn]++;
                    sum--;
                }
               gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn],true );
               PlayerTurn++;

               gui.getUserButtonPressed(
                       "press to roll dice"
               );
                }
            }

        }



