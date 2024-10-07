package org.example;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Check Number Of Players is 4")
    void R_test1(){

        Main game = new Main();

        // test 1, there should be 4 players
        int num_players = game.get_num_players();
        assertEquals(4, num_players);
    }


    // check deck size test 2


    // check for duplicates



    //
}