package org.example;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private String player_name;
    private List<Cards> player_cards = new ArrayList<Cards>();

    public Players(String player_name){
        this.player_name = player_name;
    }

    // getter
    public String get_player_name(){
        return player_name;
    }

    public List<Cards> get_player_cards(){
        return player_cards;
    }

    // print a players cards
    public void print_player_hand(){
        System.out.println("Player " + get_player_name() + "has these cards: ");
        for(Cards card : player_cards){
            card.print_card();
        }
    }



}

