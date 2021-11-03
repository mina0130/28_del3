import java.util.*;
import java.util.Random;
public class Monopoly {
    public static void main(String[] args) {
        Random dice1 = new Random();
        Random dice2 = new Random();
        boolean lose=false; // bliver true når en spiller har tabt, dvs spillet er slut
        int PlayerTurn; //1,2,3 eller 4, afhængig af vis tur det er
        int sum, dice1throw, dice2throw;

        //Game flow starter her
        while(!lose){
            dice1throw=1+dice1.nextInt(6);
            dice2throw=1+dice2.nextInt(6);
            sum=dice1throw+dice2throw;



        }


    }


}
