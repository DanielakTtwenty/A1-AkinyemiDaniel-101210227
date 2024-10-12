package org.example;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final String player_name;
    private final List<Cards> player_cards = new ArrayList<Cards>();
    private final int player_shields = 0;

    public Players(String player_name){
        this.player_name = player_name;
    }

    // getter
    public String get_player_name(){
        return player_name;
    }

    public int get_player_shields() {
        return player_shields;
    }


    public List<Cards> get_player_cards(){
        return player_cards;
    }


    // print a players cards
    public void print_player_hand(){
        System.out.println( player_name + "has " + player_shields+ " shields and has these cards: ");
        for(Cards card : player_cards){
            card.print_card();
        }
    }



}

