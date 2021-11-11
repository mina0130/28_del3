package main.java;

import java.util.Random;
public class Die{

  Random dice=new Random();

    private static int die;

    public void roll(){
        die=1+dice.nextInt(6);
    }


    public int getDice(){
        return die;
    }


    }
