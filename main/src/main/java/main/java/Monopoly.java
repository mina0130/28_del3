package main.java;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.*;
public class Monopoly {

    public static void main(String[] args) {
        String wantToBuy;

        GUI_Field[] fields = GameBoard.SetFields();
GUI gui = new GUI(fields, Color.green);
        Scanner scanner = new Scanner(System.in);
        Die die = new Die();
        boolean lose=false; // bliver true når en spiller har tabt, dvs spillet er slut
        int PlayerTurn=1; //1,2,3 eller 4, afhængig af vis tur det er
        int sum, dice1throw, dice2throw, totalplayers, previousThrow=0;
        GameBoard.SetIsOwnable();

        //her laver vi players
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
        int[] playerBalance = new int[totalplayers];
        gui_fields.GUI_Player[] player = new GUI_Player[totalplayers];
        int count=0;
        for(int i=0; i<totalplayers; i++){
            count++;
            playername[i]=gui.getUserString("Input the name of Player " + count);
           player[i]=new GUI_Player(playername[i]);
           gui.getFields()[0].setCar(player[i], true);
           playerBalance[i]=3500;
        }

            //deciding who starts
        gui.showMessage("The user obtaining the highest sum will start");
            for(int i=0; i<totalplayers; i++){
                gui.getUserString(playername[i] + " press enter to roll dice");
                die.roll();
                dice1throw=die.getDice();
                die.roll();
                dice2throw=die.getDice();
            gui.setDice(dice1throw, dice2throw);
            sum=dice1throw+dice2throw;
            if(sum>previousThrow){
                PlayerTurn=i;
            }
            else if(sum==previousThrow){
                gui.showMessage("Your throw equals another throw. Please roll again");
                i--;
            }
            previousThrow=sum;
            }
            gui.displayChanceCard("Player " + (PlayerTurn+1) + " starts");

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
            gui.getFields()[currentField[PlayerTurn]].removeAllCars();

                while(currentField[PlayerTurn]<16 && sum!=0){
                    if(currentField[PlayerTurn]==15){
                        currentField[PlayerTurn]=0;
                    }
                    currentField[PlayerTurn]++;
                    sum--;
                }
            gui.displayChanceCard(playername[PlayerTurn] + ", You are now on the " + GameBoard.getTitle(currentField[PlayerTurn]) + " field");
               gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn],true );


               if(currentField[PlayerTurn]==0){
                   playerBalance[PlayerTurn]=Bank.add(playerBalance[PlayerTurn], 200);
                   gui.displayChanceCard("You receive 200 cash on start");
                   gui.showMessage(playername[PlayerTurn] + ", your balance is now " + playerBalance[PlayerTurn]);
               }
               if(GameBoard.getIsOwnable(currentField[PlayerTurn])){
                   if(GameBoard.getIsOwned(currentField[PlayerTurn])){
                       gui.showMessage("the field is owned by player " + playername[GameBoard.getOwnedBy(currentField[PlayerTurn])] + ". 200 rent has been deducted from your account");
                       playerBalance[PlayerTurn]=Bank.deduct(playerBalance[PlayerTurn], 200);
                       playerBalance[GameBoard.getOwnedBy(currentField[PlayerTurn])]=Bank.add(playerBalance[GameBoard.getOwnedBy(currentField[PlayerTurn])], 200);
                   }
                   else if(!GameBoard.getIsOwned(currentField[PlayerTurn])){
                      wantToBuy=gui.getUserString("do you want to buy " + GameBoard.getTitle(currentField[PlayerTurn]) + " for " + GameBoard.getPrice(currentField[PlayerTurn]) + "? Type 'yes' or 'no'" );
                      while(!wantToBuy.equals("yes") && !wantToBuy.equals("no"))
                          wantToBuy=gui.getUserString("please type either 'yes' or 'no' ");
                      if(wantToBuy.equals("yes")){
                          playerBalance[PlayerTurn]=Bank.deduct(playerBalance[PlayerTurn], GameBoard.getPrice(currentField[PlayerTurn]));
                          GameBoard.setIsOwned(currentField[PlayerTurn]);
                          GameBoard.setOwnedBy(currentField[PlayerTurn], PlayerTurn);
                      }
                   }
                   gui.showMessage(playername[PlayerTurn] + ", your balance is now " + playerBalance[PlayerTurn]);
                }
               if(currentField[PlayerTurn]==12){
                   gui.displayChanceCard("you get an extra hit");
                   PlayerTurn--;
               }

               if(playerBalance[PlayerTurn]<=0){
                   lose=true;
               }
               PlayerTurn++;
               gui.showMessage(playername[PlayerTurn-1] + "'s balance has fallen below 0");
            }

        //deciding who wins
        int temp=0, win=0;
        for(int i=0; i<totalplayers; i++){
            if(playerBalance[i]>temp){
                win=i+1;
                temp=playerBalance[i];
            }
        }
        gui.showMessage("The winner is player " + win);

        }}



