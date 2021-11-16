package main.java;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import java.awt.*;
import java.io.*;
public class Monopoly {

    public static void main(String[] args) {
        String wantToBuy;


        GUI_Field[] fields = GameBoard.SetFields();
        boolean extra=false;
        int løsepenge=0;
GUI gui = new GUI(fields, Color.green);
        Die die = new Die();
        boolean lose=false; // bliver true når en spiller har tabt, dvs spillet er slut
        int PlayerTurn=1; //1,2,3 eller 4, afhængig af vis tur det er
        int sum, dice1throw, dice2throw, totalplayers, previousThrow=0;
        GameBoard.SetIsOwnable();
        boolean button=gui.getUserLeftButtonPressed("Choose language", "English", "Dansk");
        String[] read = new String[51];
        String file;
        if(button==true){
            file = "C:\\Users\\minah\\Documents\\University\\CDIO\\oversættelse-til-engelsk.txt"; }
        else {
            file= "C:\\Users\\minah\\Documents\\University\\Introductory Programming\\oversættelse-til-dansk";
        }

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for(int i=0; i<51; i++){
                try {
                    read[i] = reader.readLine();
                    System.out.println(read[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        //her laver vi players
        totalplayers= gui.getUserInteger(read[0]);
        while(totalplayers<2 || totalplayers>4){
            totalplayers=gui.getUserInteger(read[2]);
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
            playername[i]=gui.getUserString(read[1] + " " + count);
           player[i]=new GUI_Player(playername[i]);
           gui.getFields()[0].setCar(player[i], true);
           playerBalance[i]=3500;
        }

            //deciding who starts
        gui.showMessage(read[3]);
            for(int i=0; i<totalplayers; i++){
                gui.getUserString(playername[i] + " " + read[4]);
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
                gui.showMessage(read[5]);
                i--;
            }
            previousThrow=sum;
            }
            gui.displayChanceCard(playername[PlayerTurn] + read[6]);

            // game flow starts here
        while(!lose) {
            if (PlayerTurn >= totalplayers) {
                PlayerTurn = 0;
            }
            gui.getUserString(playername[PlayerTurn] + " " + read[4]);
            die.roll();
            dice1throw = die.getDice();
            die.roll();
            dice2throw = die.getDice();
            gui.setDice(dice1throw, dice2throw);
            sum = dice1throw + dice2throw;

            gui.getFields()[currentField[PlayerTurn]].removeAllCars();

            for(int i=0; i<totalplayers; i++){
                if(i!=PlayerTurn) {
                    if (currentField[i] == currentField[PlayerTurn]) {
                        gui.getFields()[currentField[i]].setCar(player[i], true);
                    }
                }
            }
            while (currentField[PlayerTurn] < 16 && sum != 0) {
                if (currentField[PlayerTurn] == 15) {
                    currentField[PlayerTurn] = 0;
                }
                currentField[PlayerTurn]++;
                sum--;
            }
            gui.displayChanceCard(playername[PlayerTurn] + " " + read[7] + " " + GameBoard.getTitle(currentField[PlayerTurn]) + " " + read[8]);
            gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn], true);


            int card;
            if (currentField[PlayerTurn] == 2 | currentField[PlayerTurn] == 6 | currentField[PlayerTurn] == 10 | currentField[PlayerTurn] == 14) {
                die.roll();
                card = die.getDice();
                die.roll();
                card = card + die.getDice();

                switch (card) {
                    case 2:
                        gui.displayChanceCard(read[9]);
                        gui.getFields()[currentField[PlayerTurn]].removeAllCars();
                        for(int i=0; i<totalplayers; i++){
                            if(i!=PlayerTurn) {
                                if (currentField[i] == currentField[PlayerTurn]) {
                                    gui.getFields()[currentField[i]].setCar(player[i], true);
                                }
                            }
                        }
                        currentField[PlayerTurn] = 0;
                        gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn], true);
                        break;
                    case 3:
                        gui.displayChanceCard(read[10]);
                        gui.getFields()[currentField[PlayerTurn]].removeAllCars();
                        for(int i=0; i<totalplayers; i++){
                            if(i!=PlayerTurn) {
                                if (currentField[i] == currentField[PlayerTurn]) {
                                    gui.getFields()[currentField[i]].setCar(player[i], true);
                                }
                            }
                        }
                        currentField[PlayerTurn] = 8;
                        gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn], true);
                        break;
                    case 4:
                        gui.displayChanceCard(read[11]);
                        gui.getFields()[currentField[PlayerTurn]].removeAllCars();
                        for(int i=0; i<totalplayers; i++){
                            if(i!=PlayerTurn) {
                                if (currentField[i] == currentField[PlayerTurn]) {
                                    gui.getFields()[currentField[i]].setCar(player[i], true);
                                }
                            }
                        }
                        currentField[PlayerTurn] = 15;
                        gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn], true);
                        break;
                    case 5:
                        gui.displayChanceCard(read[12]);
                        gui.getFields()[currentField[PlayerTurn]].removeAllCars();
                        for(int i=0; i<totalplayers; i++){
                            if(i!=PlayerTurn) {
                                if (currentField[i] == currentField[PlayerTurn]) {
                                    gui.getFields()[currentField[i]].setCar(player[i], true);
                                }
                            }
                        }
                        currentField[PlayerTurn] = 4;
                        gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn], true);
                        break;
                    case 6:
                        gui.displayChanceCard("Du har tabt 500");
                        playerBalance[PlayerTurn] = Bank.deduct(playerBalance[PlayerTurn], 500);
                        break;
                    case 7:
                        gui.displayChanceCard("du har modtaget 500");
                        playerBalance[PlayerTurn] = Bank.add(playerBalance[PlayerTurn], 500);
                        break;
                    case 8:
                        gui.displayChanceCard("du har tabt 100");
                        playerBalance[PlayerTurn] = Bank.deduct(playerBalance[PlayerTurn], 100);
                        break;
                    case 9:
                        gui.displayChanceCard("du har modtaget 50");
                        playerBalance[PlayerTurn] = Bank.add(playerBalance[PlayerTurn], 50);
                        break;
                    case 10:
                        gui.displayChanceCard("Ryk 2 felter tilbage");
                        gui.getFields()[currentField[PlayerTurn]].removeAllCars();
                        for(int i=0; i<totalplayers; i++){
                            if(i!=PlayerTurn) {
                                if (currentField[i] == currentField[PlayerTurn]) {
                                    gui.getFields()[currentField[i]].setCar(player[i], true);
                                }
                            }
                        }
                        currentField[PlayerTurn] = currentField[PlayerTurn] - 2;
                        gui.getFields()[currentField[PlayerTurn]].setCar(player[PlayerTurn], true);
                        break;
                    case 11:
                        gui.displayChanceCard("eksta tur");
                        extra = true;
                        break;
                    case 12:
                        gui.displayChanceCard("intet sker :)");
                        break;
                }
                gui.showMessage(" ");
            }
               if(currentField[PlayerTurn]==0){
                   playerBalance[PlayerTurn]=Bank.add(playerBalance[PlayerTurn], 200);
                   gui.displayChanceCard("You receive 200 cash on start");
               }
               if(GameBoard.getIsOwnable(currentField[PlayerTurn])){
                   if(GameBoard.getIsOwned(currentField[PlayerTurn])){
                       if(GameBoard.getOwnedBy(currentField[PlayerTurn])!=PlayerTurn) {
                           gui.showMessage("the field is owned by player " + playername[GameBoard.getOwnedBy(currentField[PlayerTurn])] + ". " + GameBoard.getRent(currentField[PlayerTurn]) + " rent has been deducted from your account");
                           playerBalance[PlayerTurn] = Bank.deduct(playerBalance[PlayerTurn], GameBoard.getRent(currentField[PlayerTurn]));
                           playerBalance[GameBoard.getOwnedBy(currentField[PlayerTurn])] = Bank.add(playerBalance[GameBoard.getOwnedBy(currentField[PlayerTurn])], GameBoard.getRent(currentField[PlayerTurn]));
                           gui.showMessage(playername[GameBoard.getOwnedBy(currentField[PlayerTurn])] + "'s balance is now " + playerBalance[GameBoard.getOwnedBy(currentField[PlayerTurn])]);
                       }
                   else if(GameBoard.getOwnedBy(currentField[PlayerTurn])==PlayerTurn){
                   gui.showMessage("You already own this field"); }
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
                }
               if(currentField[PlayerTurn]==4){
                   if(løsepenge>=200){
                   gui.displayChanceCard("You have landed on the loose money field. 200 has been added to your balance");
                   løsepenge=løsepenge-200;
                   playerBalance[PlayerTurn]=Bank.add(playerBalance[PlayerTurn], 200);}
                   else{
                       gui.displayChanceCard("you have landed on the loose money field. Unfortunately the field is empty");
                   }
               }
               if(currentField[PlayerTurn]==8){
                   gui.displayChanceCard("You have landed on the 'deposit cash' field. 200 has been deducted from your account");
               løsepenge=løsepenge+200;
               playerBalance[PlayerTurn]=Bank.deduct(playerBalance[PlayerTurn], 200);
               }
               if(currentField[PlayerTurn]==12){
                   gui.displayChanceCard("you get an extra hit");
                   extra=true;
               }


               switch(currentField[PlayerTurn]){
                   case 1,2,3,4,5,6,7,8,9,10,11,13,14,15:  gui.showMessage(playername[PlayerTurn] + ", your balance is now " + playerBalance[PlayerTurn]);
               }

               if(playerBalance[PlayerTurn]<=0){
                   lose=true;
                   gui.showMessage(playername[PlayerTurn-1] + "'s balance has fallen below 0");
               }
               if(!extra){
               PlayerTurn++;}
               extra=false;
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



