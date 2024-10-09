package org.example;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Check Number Of Players is 4")
    void R_test1(){
        // test 1, there should be 4 players
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

    //
}