package org.example;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("Comp4004, Let's Play");

    Main game = new Main();

    //game.get_num_players();
    //game.populate_adventure_deck();
    //game.populate_event_deck();

    }

    public int get_num_players(){


        // uncomment for dynamism. the number of players is 4
        int num_players = 4;

//        Scanner get_num = new Scanner(System.in);
//        System.out.println("Enter Number of Players: ");
//        num_players = get_num.nextInt();
//
//        get_num.close();

        return num_players;
    }


    public void populate_adventure_deck(){

    }

    public int get_adventure_deck_size(){
        return 0;
    }


    public void populate_event_deck(){

    }

    public int get_event_deck_size(){
        return 0;
    }



}