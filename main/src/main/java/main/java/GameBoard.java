package main.java;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GameBoard {

public static GUI_Field[] fields = new GUI_Field[16];

// public void settingcar(GUI_Player player){
 //fields[0].setCar(player, true);}

 public static gui_fields.GUI_Field[] SetFields(){
     fields[0]=new GUI_Start();
     fields[0].setTitle("Start");
     fields[0].setSubText("Modtag 200kr");
     fields[0].setBackGroundColor(Color.white);
     fields[1]=new GUI_Street();
  fields[1].setTitle("Biografen");
  fields[1].setSubText("200kr");
  fields[1].setBackGroundColor(Color.blue);
  fields[2]=new GUI_Chance();
  fields[2].setTitle("CHANCE?");
  fields[2].setSubText("");
  fields[2].setBackGroundColor(Color.orange);
  fields[3]=new GUI_Street();
  fields[3].setTitle("Pizzaria");
  fields[3].setSubText("200kr");
  fields[3].setBackGroundColor(Color.blue);
  fields[4]=new GUI_Tax();
  fields[4].setTitle("Jernbane!");
  fields[4].setSubText("Du har nået jernbanen, du får en EKSTRA tur");
  fields[4].setBackGroundColor(Color.green);
  fields[5]=new GUI_Street();
  fields[5].setTitle("Museet");
  fields[5].setSubText("300kr");
  fields[5].setBackGroundColor(Color.blue);
  fields[6]=new GUI_Chance();
  fields[6].setTitle("CHANCE?");
  fields[6].setSubText("");
  fields[6].setBackGroundColor(Color.orange);
  fields[7]=new GUI_Street();
  fields[7].setTitle("Tivoli");
  fields[7].setSubText("300kr");
  fields[7].setBackGroundColor(Color.blue);
  fields[8]=new GUI_Tax();
  fields[8].setTitle("Betal 200kr!");
  fields[8].setSubText("Du skal dsv betale en vejafgift på 200kr");
  fields[8].setBackGroundColor(Color.red);
  fields[9]=new GUI_Street();
  fields[9].setTitle("Casino");
  fields[9].setSubText("400kr");
  fields[9].setBackGroundColor(Color.blue);
  fields[10]=new GUI_Chance();
  fields[10].setTitle("CHANCE?");
  fields[10].setSubText("");
  fields[10].setBackGroundColor(Color.orange);
  fields[11]=new GUI_Street();
  fields[11].setTitle("Zoo");
  fields[11].setSubText("400kr");
  fields[11].setBackGroundColor(Color.blue);
  fields[12]=new GUI_Tax();
  fields[12].setTitle("Løsepenge");
  fields[12].setSubText("Tillykke du modtager penge");
  fields[12].setBackGroundColor(Color.cyan);
  fields[13]=new GUI_Street();
  fields[13].setTitle("Vandland");
  fields[13].setSubText("500kr");
  fields[13].setBackGroundColor(Color.blue);
  fields[14]=new GUI_Chance();
  fields[14].setTitle("CHANCE?");
  fields[14].setSubText("");
  fields[14].setBackGroundColor(Color.orange);
  fields[15]=new GUI_Street();
  fields[15].setTitle("Bowlingcenter");
  fields[15].setSubText("500kr");
  fields[15].setBackGroundColor(Color.blue);
return fields;
 }

 public static String getTitle(int fieldnumber){
     return fields[fieldnumber].getTitle();
 }

static boolean[] isOwnable = new boolean[16];

public static void SetIsOwnable(){
  isOwnable[0] = false;
  isOwnable[1] = true;
  isOwnable[2] = false;
  isOwnable[3] = true;
  isOwnable[4] = false;
  isOwnable[5] = true;
  isOwnable[6] = false;
  isOwnable[7] = true;
  isOwnable[8] = false;
  isOwnable[9] = true;
  isOwnable[10] = false;
  isOwnable[11] = true;
  isOwnable[12] = false;
  isOwnable[13] = true;
  isOwnable[14] = false;
  isOwnable[15] = true; }

    public static boolean getIsOwnable(int fieldNumber){
  return isOwnable[fieldNumber];
}

 static boolean[] isOwned = new boolean[16]; {
  isOwned[0] = false;
  isOwned[1] = false;
  isOwned[2] = false;
  isOwned[3] = false;
  isOwned[4] = false;
  isOwned[5] = false;
  isOwned[6] = false;
  isOwned[7] = false;
  isOwned[8] = false;
  isOwned[9] = false;
  isOwned[10] = false;
  isOwned[11] = false;
  isOwned[12] = false;
  isOwned[13] = false;
  isOwned[14] = false;
  isOwned[15] = false;
 }

 public static void setIsOwned(int fieldNumber) {
  int number = fieldNumber;
  isOwned[fieldNumber] = true;

 }

 public static boolean getIsOwned(int fieldNumber) {return isOwned[fieldNumber]; }
 static int[] price = new int[16];

 {
  price[1] = 200;
  price [3] = 200;
  price [5] = 300;
  price [7] = 300;
  price [9] = 400;
  price [11] = 400;
  price [13] = 500;
  price [15] = 500;
 }

 public static int getPrice(int fieldNumber){return price[fieldNumber]; }

 static int[] rent = new int[16]; {
  rent[1] = 200;
  rent[3] = 200;
  rent[5] = 300;
  rent[7] = 300;
  rent[9] = 400;
  rent[11] = 400;
  rent[13] = 500;
  rent[15] = 500;
 }

 public static int getRent(int fieldNumber){return rent[fieldNumber]; }

 static int[] ownedBy = new int[16]; {
  ownedBy[1] = 0;
  ownedBy[3] = 0;
  ownedBy[5] = 0;
  ownedBy[7] = 0;
  ownedBy[9] = 0;
  ownedBy[11] = 0;
  ownedBy[13] = 0;
  ownedBy[15] = 0;
 }

 public static void setOwnedBy(int fieldNumber, int playerColor) {
  ownedBy[fieldNumber] = playerColor;

 }

 public static int getOwnedBy(int fieldNumber) {return ownedBy[fieldNumber]; }

 //felter i array
  {
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street();
         new GUI_Street(); };

 //tekst til felter


 public void setFieldsSubText (int fieldNumber, String subText) {fields[fieldNumber].setSubText(subText); }

}

