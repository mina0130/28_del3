package main.java;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import java.util.*;
import java.util.Random;

public class Monopoly {

    public static void main(String[] args) {

        GUI gui = new GUI();
        GUI_Field[] fields = new GUI_Field[16];
        Scanner scanner = new Scanner(System.in);
        Random dice1 = new Random();
        Random dice2 = new Random();
        boolean lose=false; // bliver true når en spiller har tabt, dvs spillet er slut
        int PlayerTurn=1; //1,2,3 eller 4, afhængig af vis tur det er
        int sum, dice1throw, dice2throw, totalplayers, previousThrow=0, thrower=1;


        //her laver vi players
        System.out.println("input Number of Players");
        totalplayers=scanner.nextInt();
        String[] playername = new String[totalplayers];

        int count=0;
        for(int i=0; i<totalplayers; i++){
            count++;
System.out.println("Input the name of Player " + count);
            playername[i]=scanner.next();

        }
        for(int i=0; i<totalplayers; i++){
        }


            //deciding who starts
            for(int i=0; i<totalplayers; i++){
                System.out.print("press enter to roll dice");
                while(thrower!=0){
                    thrower=scanner.nextInt();
                }
            dice1throw=1+dice1.nextInt(6);
            dice2throw=1+dice2.nextInt(6);
            System.out.println("dice 1 face value is " + dice1throw);
            System.out.println("dice 2 face value is " + dice2throw);
            gui.setDice(dice1throw, dice2throw);
            sum=dice1throw+dice2throw;
            System.out.println("The sum of your throw is " + sum);
            if(sum>previousThrow){
                PlayerTurn=i+1;
            }
            previousThrow=sum;
            }
            System.out.println("player " + PlayerTurn + " Starts");

        }


    }


