package org.example;



import java.util.*;

public class Main {

    public static void main(String[] args) {


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("Comp4004, Let's Play");

    Main game = new Main();

    game.get_num_players();
    game.populate_adventure_deck();
    game.populate_event_deck();
    game.populate_player_hands();
    //game.print_all_player_cards();
    game.play_game();

    }

    // Adventure and Event card decks
    private final List<Cards> adventure_deck = new ArrayList<>();
    private final List<Cards> event_deck = new ArrayList<>();

    // repurposed deck for adventure cards
    private final List<Cards> used_adventure_deck = new ArrayList<>();

    private Players [] players;

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

        // Battle-axes cards
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
            event_deck.add(new Cards("Plague",2, (i+1)));
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

    public void populate_player_hands(){
        // give the game the chosen number of players 4
        players = new Players[get_num_players()];

        // add all the players and their names
        for(int i =0; i<get_num_players(); i++){
            players[i] = new Players(String.format("Player %d", i+1));
        }

        //System.out.println("Before (100) " +adventure_deck.size());

        // add 12 cards per person
        for (Players player: players){
            for(int i =0; i<12; i++){
                player.get_player_cards().add(adventure_deck.get(0));
                adventure_deck.remove(0);
            }
        }
    }

    public void print_all_player_cards(){
        for(Players player: players){
            player.print_player_hand();
        }
    }

    public Players[] get_players(){
        return players;
    }

    // draw event card takes the top element frm the deck and returns it
    // then removes it from the top and adds it to the bottom.
    public Cards draw_event_card(){
        Cards card = event_deck.get(0);
        event_deck.remove(0);
        event_deck.add(card);
        return card;
    }

    // method generates a number from 1-12
    public int get_rand_num(){
        Random num = new Random();
        return num.nextInt(12);
    }

    public int del_player_input(Scanner card_pos){
        int pos =0;
        do{
            System.out.println("Please Enter Number from 1 - 12");
            pos = card_pos.nextInt();
        }while(pos<1 || pos >12);

        return pos-1;
    }

    // function to remove 2 adventure cards and replace them
    // function takes player position as int
    public void pick_two(int pos){
        // pick 2 new cards from adventure cards
        // (remove from adv deck and add them to player hand)

        players[pos].get_player_cards().add(adventure_deck.get(0));
        adventure_deck.remove(0);
        players[pos].get_player_cards().add(adventure_deck.get(0));
        adventure_deck.remove(0);

        System.out.println("Enter 2 numbers of cards to delete");
        Scanner delete_card_pos = new Scanner(System.in);

        int c1 = del_player_input(delete_card_pos);
        int c2 = del_player_input(delete_card_pos);

        System.out.println("Should be 14 ---> "  + players[pos].get_player_cards().size());
        // remove the 2 cards that the player picked
        used_adventure_deck.add(players[pos].get_player_cards().remove(c1));
        used_adventure_deck.add(players[pos].get_player_cards().remove(c2));

        System.out.println("Should be 12 ---> "  + players[pos].get_player_cards().size());

    }


    // player turn starts from first to last
    int player_pos = 0;

    public Players play_game(){
        boolean flag = true;

        // Currently drawn event card
        Cards curr_event_card;

        // make sure player_pos is always less that num_players
        if(player_pos >= get_num_players()){
            player_pos =0;
        }

        while(flag){

            // player in current position draws event card
            curr_event_card = draw_event_card();

            // print player and player position
            System.out.println(players[player_pos].get_player_name() + " current position: " + player_pos);

            // print the card the player picked
            System.out.print(players[player_pos].get_player_name() + " picked ");
            curr_event_card.print_card();

            // if the card is a plague card lose 2 shields
            if(curr_event_card.get_card_suit().equals("Plague")){
                players[player_pos].set_player_shields(players[player_pos].get_player_shields()-2);
            }


            //if the card drawn by current player is Queen's Favor pick 2 adventure cards
            // remember a player can only have 12 adventure cards
            // so the player will drop 2 adventure cards also. //add to used_ad..._deck
            if(curr_event_card.get_card_suit().equals("Queen's Favor")){
                players[player_pos].print_player_hand();
                pick_two(player_pos);
                players[player_pos].print_player_hand();
            }

            //if the card drawn by current player is Prosperity, everyone picks 2 adventure cards
            // everyone drops 2 adv cards and picks 2
            if(curr_event_card.get_card_suit().equals("Prosperity")){
                for(int i =0; i<get_num_players(); i++){
                    pick_two(i);
                }
            }

            // check if the card suit is "Q"
            // then solve accordingly
            if(curr_event_card.get_card_suit().equals("Q")){
                System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
            }


            // check if adventure deck < 8
            // only 6 adventure cards would be needed at most for an event
            // take the cards in used-adventure-deck, add to adventure deck and shuffle
            if (adventure_deck.size() < 8){
                Collections.shuffle(used_adventure_deck);
                adventure_deck.addAll(used_adventure_deck);
                used_adventure_deck.clear();
            }

            flag = false;
        }

        return new Players("A");
    }



}