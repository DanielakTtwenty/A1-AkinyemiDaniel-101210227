package org.example;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("Comp4004, Let's Play");

    Main game = new Main();

    game.get_num_players();
    game.populate_adventure_deck();
    game.populate_event_deck();

    }

    // Adventure and Event card decks
    private List<Cards> adventure_deck = new ArrayList<Cards>();
    private List<Cards> event_deck = new ArrayList<Cards>();

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

        // F5 cards
        for(int i =0; i < 8; i++){
            adventure_deck.add(new Cards("F",5, (i+1)));
        }

        // F10 cards
        for(int i =0; i < 7; i++){
            adventure_deck.add(new Cards("F",10, (i+1)));
        }

        // F10 cards
        for(int i =0; i < 8; i++){
            adventure_deck.add(new Cards("F",15, (i+1)));
        }

        // F10 cards
        for(int i =0; i < 7; i++){
            adventure_deck.add(new Cards("F",20, (i+1)));
        }

        // F25 cards
        for(int i =0; i < 7; i++){
            adventure_deck.add(new Cards("F",25, (i+1)));
        }

        // F30 cards
        for(int i =0; i < 4; i++){
            adventure_deck.add(new Cards("F",30, (i+1)));
        }

        // F35 cards
        for(int i =0; i < 4; i++){
            adventure_deck.add(new Cards("F",35, (i+1)));
        }

        // F40 cards
        for(int i =0; i < 2; i++){
            adventure_deck.add(new Cards("F",40, (i+1)));
        }

        // F50 cards
        for(int i =0; i < 2; i++){
            adventure_deck.add(new Cards("F",50, (i+1)));
        }

        // F70 card
        for(int i =0; i < 1; i++){
            adventure_deck.add(new Cards("F",70, (i+1)));
        }

        // Daggers cards
        for(int i =0; i < 6; i++){
            adventure_deck.add(new Cards("D",5, (i+1)));
        }

        // Horses cards
        for(int i =0; i < 12; i++){
            adventure_deck.add(new Cards("H",10, (i+1)));
        }


        // Swords cards
        for(int i =0; i < 16; i++){
            adventure_deck.add(new Cards("S",10, (i+1)));
        }

        // Battle axes cards
        for(int i =0; i < 8; i++){
            adventure_deck.add(new Cards("B",15, (i+1)));
        }

        // Lances cards
        for(int i =0; i < 6; i++){
            adventure_deck.add(new Cards("L",20, (i+1)));
        }

        // Excalibur cards
        for(int i =0; i < 2; i++){
            adventure_deck.add(new Cards("E",30, (i+1)));
        }

        // shuffle deck
        Collections.shuffle(adventure_deck);


        // print out deck (just to see )
//        System.out.println("The number of cards == " + adventure_deck.size());
//        System.out.println("____________________________");
//
//        for(Cards card : adventure_deck){
//            card.print_card();
//        }
    }

    public int get_adventure_deck_size(){
        return adventure_deck.size();
    }

    public void populate_event_deck(){

        // Q2 cards
        for(int i =0; i < 3; i++){
            event_deck.add(new Cards("Q",2, (i+1)));
        }

        // Q3 cards
        for(int i =0; i < 4; i++){
            event_deck.add(new Cards("Q",3, (i+1)));
        }

        // Q4 cards
        for(int i =0; i < 3; i++){
            event_deck.add(new Cards("Q",4, (i+1)));
        }

        // Q5 cards
        for(int i =0; i < 2; i++){
            event_deck.add(new Cards("Q",5, (i+1)));
        }

        // E cards

        // Plaque Card
        for(int i =0; i < 1; i++){
            event_deck.add(new Cards("Plaque",2, (i+1)));
        }

        // Queen's Fav  cards
        for(int i =0; i < 2; i++){
            event_deck.add(new Cards("Queen's Favor",2, (i+1)));
        }

        // Prosperity Fav  cards
        for(int i =0; i < 2; i++){
            event_deck.add(new Cards("Prosperity",2, (i+1)));
        }


        // shuffle deck
        Collections.shuffle(event_deck);

         //print out deck (just to see)
//        System.out.println("The number of cards == " + event_deck.size());
//        System.out.println("____________________________");
//
//        for(Cards card : event_deck){
//            card.print_card();
//        }

    }
    public int get_event_deck_size(){
        return event_deck.size();
    }



}