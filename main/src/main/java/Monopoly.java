package main.java;

import java.util.*;
import java.util.Random;
public class Monopoly {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random dice1 = new Random();
        Random dice2 = new Random();
        boolean lose=false; // bliver true når en spiller har tabt, dvs spillet er slut
        int PlayerTurn=1; //1,2,3 eller 4, afhængig af vis tur det er
        int sum, dice1throw, dice2throw, totalplayers, previousThrow=0;


        //her laver vi players
        System.out.println("input Number of Players");
        totalplayers=scanner.nextInt();



        //Game flow starter her
        while(!lose){
            //deciding who starts
            for(int i=0; i<totalplayers; i++){
            dice1throw=1+dice1.nextInt(6);
            dice2throw=1+dice2.nextInt(6);
            sum=dice1throw+dice2throw;
            if(sum>previousThrow){
                PlayerTurn=i+1;
            }
            previousThrow=sum;
            }
            System.out.println("player " + PlayerTurn + " Starts");





        }


    }


}
