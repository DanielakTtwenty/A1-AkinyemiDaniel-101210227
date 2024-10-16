package org.example;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final String player_name;
    private final List<Cards> player_cards = new ArrayList<Cards>();

    private final int player_position;

    private int player_shields = 0;

    public Players(String player_name,int player_position){
        this.player_name = player_name;
        this.player_position = player_position;
    }

    // getter
    public String get_player_name(){
        return player_name;
    }

    public int get_player_shields() {
        return player_shields;
    }

    public int get_player_pos(){
        return player_position;
    }

    // setter
    public void set_player_shields(int player_shields){

        if(player_shields < 0){
            this.player_shields = 0;
        }
        this.player_shields = player_shields;
    }

    public List<Cards> get_player_cards(){
        return player_cards;
    }


    // print a players cards
    public void print_player_hand(){
        System.out.println(player_name + " position number: " + player_position +" has " + player_shields+ " shields and has these cards: ");
        int i =0;
        for(Cards card : player_cards){
            System.out.print(i+1 + ". ");
            card.print_card();
            i++;
        }

    }



}

