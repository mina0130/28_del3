package main.java;
import gui_fields.*;
import gui_main.GUI;

import javax.xml.stream.events.StartDocument;
import java.awt.*;
import java.io.*;

public class GameBoard {

public static GUI_Field[] fields = new GUI_Field[16];

public static String file;
public static String[] read = new String[86];

   static BufferedReader reader = null;


// public void settingcar(GUI_Player player){
 //fields[0].setCar(player, true);}

 public static gui_fields.GUI_Field[] SetFields(){
     fields[0]=new GUI_Start();
     fields[0].setTitle(read[65]);
     fields[0].setSubText(read[66]);
     fields[0].setBackGroundColor(Color.white);
     fields[1]=new GUI_Street();
  fields[1].setTitle(read[67]);
  fields[1].setSubText(read[68]);
  fields[1].setBackGroundColor(Color.blue);
  fields[2]=new GUI_Chance();
  fields[2].setTitle(read[69]);
  fields[2].setSubText("");
  fields[2].setBackGroundColor(Color.orange);
  fields[3]=new GUI_Street();
  fields[3].setTitle(read[70]);
  fields[3].setSubText(read[68]);
  fields[3].setBackGroundColor(Color.blue);
  fields[12]=new GUI_Tax();
  fields[12].setTitle(read[71]);
  fields[12].setSubText(read[72]);
  fields[12].setBackGroundColor(Color.green);
  fields[5]=new GUI_Street();
  fields[5].setTitle(read[73]);
  fields[5].setSubText(read[74]);
  fields[5].setBackGroundColor(Color.blue);
  fields[6]=new GUI_Chance();
  fields[6].setTitle(read[69]);
  fields[6].setSubText("");
  fields[6].setBackGroundColor(Color.orange);
  fields[7]=new GUI_Street();
  fields[7].setTitle(read[75]);
  fields[7].setSubText(read[74]);
  fields[7].setBackGroundColor(Color.blue);
  fields[8]=new GUI_Tax();
  fields[8].setTitle(read[76]);
  fields[8].setSubText(read[77]);
  fields[8].setBackGroundColor(Color.red);
  fields[9]=new GUI_Street();
  fields[9].setTitle(read[78]);
  fields[9].setSubText(read[79]);
  fields[9].setBackGroundColor(Color.blue);
  fields[10]=new GUI_Chance();
  fields[10].setTitle(read[69]);
  fields[10].setSubText("");
  fields[10].setBackGroundColor(Color.orange);
  fields[11]=new GUI_Street();
  fields[11].setTitle(read[80]);
  fields[11].setSubText(read[79]);
  fields[11].setBackGroundColor(Color.blue);
  fields[4]=new GUI_Tax();
  fields[4].setTitle(read[81]);
  fields[4].setSubText(read[82]);
  fields[4].setBackGroundColor(Color.cyan);
  fields[13]=new GUI_Street();
  fields[13].setTitle(read[83]);
  fields[13].setSubText(read[84]);
  fields[13].setBackGroundColor(Color.blue);
  fields[14]=new GUI_Chance();
  fields[14].setTitle(read[69]);
  fields[14].setSubText("");
  fields[14].setBackGroundColor(Color.orange);
  fields[15]=new GUI_Street();
  fields[15].setTitle(read[85]);
  fields[15].setSubText(read[84]);
  fields[15].setBackGroundColor(Color.blue);
return fields;
 }

    public String toString(){
     return fields.toString();
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
  isOwned[fieldNumber] = true;

 }

 public static boolean getIsOwned(int fieldNumber) {return isOwned[fieldNumber]; }
 static int[] price = new int[16];


 public static int getPrice(int fieldNumber){
     price[1] = 200;
     price [3] = 200;
     price [5] = 300;
     price [7] = 300;
     price [9] = 400;
     price [11] = 400;
     price [13] = 500;
     price [15] = 500;
     return price[fieldNumber]; }



 public static int getRent(int fieldNumber){
     int[] rent = new int[16]; {
         rent[1] = 200;
         rent[3] = 200;
         rent[5] = 300;
         rent[7] = 300;
         rent[9] = 400;
         rent[11] = 400;
         rent[13] = 500;
         rent[15] = 500;
     }return rent[fieldNumber]; }

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

}

