package org.example;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import java.awt.desktop.SystemEventListener;
//import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // test 1, there should be 4 players
    @Test
    @DisplayName("Check Number Of Players is 4")
    void R_test1(){

        Main game = new Main();
        int num_players = game.get_num_players();
        assertEquals(4, num_players);
    }

    // test2 -  check adventure deck size (100)
    @Test
    @DisplayName("Check Adventure Deck Size is 100")
    void R_test2(){
        // there should be 100 adventure cards
        Main game = new Main();
        game.populate_adventure_deck();
        int adv_deck_size = game.get_adventure_deck_size();
        assertEquals(100, adv_deck_size);
    }


    // test3 -  check event deck size (17)
    @Test
    @DisplayName("Check Event Deck Size is 17")
    void R_test3(){
        //  there should be 17 event cards
        Main game = new Main();
        game.populate_event_deck();
        int event_deck_size = game.get_event_deck_size();
        assertEquals(17, event_deck_size);
    }

    @Test
    @DisplayName("All players have 12 cards")
    // adventure deck after sharing 48 cards should be 52
    void R_test4(){
        Main game = new Main();
        game.populate_adventure_deck();
        game.populate_event_deck();
        game.populate_player_hands();

        // 0 is true, -1 is false
        int same_number_cards = 0;

        Players[] players;
        players = game.get_players();

        for(Players player: players){

            if(player.get_player_cards().size() != 12){
                System.out.println("player hand Size is not 12--->  "+ player.get_player_cards().size());
                same_number_cards = -1;
            }
            System.out.println(player.get_player_cards().size());
        }
        assertEquals(52, game.get_adventure_deck_size());
    }

    @Test
    @DisplayName(" The Winnner has 7 shields")
    void R_test5(){
        Main game = new Main();
        game.populate_adventure_deck();
        game.populate_event_deck();
        game.populate_player_hands();

        Players p = game.play_game();
        assertEquals(7,p.get_player_shields());

    }


}