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

    // Stages
    // size is meant to be equal to card value
    public ArrayList<ArrayList<Cards>> list_stages = new ArrayList<>();

    // get the total for each stage.
    ArrayList<Integer> stage_number = new ArrayList<>();

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

    }

    public int get_event_deck_size(){
        return event_deck.size();
    }

    public void populate_player_hands(){
        // give the game the chosen number of players 4
        players = new Players[get_num_players()];

        // add all the players and their names
        for(int i =0; i<get_num_players(); i++){
            players[i] = new Players(String.format("Player %d", i+1), i+1);
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

//    public void print_all_player_cards(){
//        for(Players player: players){
//            player.print_player_hand();
//        }
//    }

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
//    public int get_rand_num(){
//        Random num = new Random();
//        return num.nextInt(12);
//    }
    public int del_player_input(Scanner card_pos){
        int pos;
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

        //System.out.println("Should be 14 ---> "  + players[pos].get_player_cards().size());
        // remove the 2 cards that the player picked
        used_adventure_deck.add(players[pos].get_player_cards().remove(c1));
        used_adventure_deck.add(players[pos].get_player_cards().remove(c2));

        //System.out.println("Should be 12 ---> "  + players[pos].get_player_cards().size());
        delete_card_pos.close();
    }

    // can remove later, #Barricade
    public void lines(){
        System.out.println("\n____________________________________________________________________\n");
    }

    // A player draws a Quest card,
    // check if the player can sponsor (Number of F cards  > Q card_value)
    public boolean can_sponsor(int player_pos, int card_value) {
        //System.out.println("You cannot Sponsor");

        // ask the player if they would like to sponsor game
        // enter 1 or 0.  1 means "yes" and 0 means "no"
        lines();
        System.out.println(String.format("Player%d will you sponsor game?: yes(1) / no(0) ",(player_pos+1)));

        Scanner play_or_not = new Scanner(System.in);
        int answer = play_or_not.nextInt();

        if(answer == 0){
            lines();
            System.out.println(String.format("Player%d will not sponsor quest", player_pos+1));
        }

        if(answer == 1) {
            lines();
            System.out.println(String.format("Player%d will sponsor quest", player_pos + 1));

            //check if player can actually sponsor quest  and print results.
            int f_cards_counter = 0;
            for (Cards c : players[player_pos].get_player_cards()) {
                if (c.get_card_suit().equals("F")) {
                    f_cards_counter++;
                }
            }
            if (f_cards_counter >= card_value) {
                lines();
                System.out.println(String.format("Player%d Has Enough Foe Cards to Sponsor This Quest: %d", player_pos + 1, f_cards_counter));
                return true;
            }
            lines();
            System.out.println(String.format("Player%d Does not Have Enough Foe Cards to Sponsor This Quest: %d", player_pos + 1, f_cards_counter));
            System.out.println("Next Player Can Try: ");
        }
        //play_or_not.close();
        return false;
    }

    // when a player cannot or chooses not to sponsor
    // write a function to pick the next player that can
    // in order to work might probably have to return player!!
    // function would use a loop to check and should constantly print to prove
    // will call can_sponsor() repeatedly so player position is important
    public int sponsor_quest(int player_pos, int card_value){

        int current_pos;
        boolean player_sponsor_decision;

        for(int i=0; i<4; i++){

            current_pos = (player_pos+i)% get_num_players();
            player_sponsor_decision = can_sponsor(current_pos, card_value);

            if(player_sponsor_decision){
                return current_pos;
            }
        }
        return -1;
    }

    // this player is drawing an adventure card.
    // player takes a card from adventure cards
    // then remove card from adventure deck
    // ask player for a card to take out
    // take the card out of player deck add to used card deck
    public void player_draw_adventure_card(Players p){

        Cards c;

        // remove card from adventure deck
        // add card to player's hand
        p.get_player_cards().add(adventure_deck.remove(0));
        p.print_player_hand();
        lines();

        // ask the player for the card to remove
        System.out.println(String.format("Player%d, pick a card from 1-12 to remove", p.get_player_pos()));

        Scanner remove_card = new Scanner(System.in);
        int answer = remove_card.nextInt();

        // remove the picked card from players hand
        // prints the card removed
        c = p.get_player_cards().remove(answer-1);
        System.out.print("The card removed is: ");
        c.print_card();

        // add removed card to unused adventure cards
        used_adventure_deck.add(c);

        lines();
        System.out.print(String.format("Player%d new hand: ", p.get_player_pos()));
        p.print_player_hand();
        lines();

    }

// prints stages
    public void print_stages(ArrayList<Cards> stage, int stage_number){

        lines();
        int stage_value = 0;

        System.out.println(String.format("Stage %d:",stage_number+1));
        for(Cards c: stage){
            stage_value += c.get_card_value();
            c.print_card();
        }
        System.out.println(String.format("Stage Value: %d",stage_value));
    }

    // build stages
    // ask the player what card the card selection, they would like to pick
    // checks if their selection is valid, has at least one foe card

    // checks if a players selected stage is valid
    public boolean stage_selection_is_accepted(ArrayList<Cards> stage){

        // to make sure card value is greater after ever add

        // this is to represent the value of previous stage. remember they should be higher after ever stage
        int count_f_cards = 0;

        // stage value
        int curr_stage_value =0;

        // check if there are more than 1 F cards
        for(Cards c : stage){
            if(c.get_card_suit().equals("F")){
                count_f_cards++;
            }
            curr_stage_value+= c.get_card_value();
        }

        if(count_f_cards!= 1){
            return false;
        }

        // check for duplicates
        for(int i=0; i<stage.size(); i++){

            Cards c1 = stage.get(i);

            for(int j= i+1; j <stage.size(); j++){
                Cards c2 = stage.get(j);

                if(c1.get_card_suit().equals(c2.get_card_suit())){
                    return false;
                }
            }
        }

        // check the card value for stage is always increasing;
        // if list_stage isEmpty  just return true, add can be added
        // take the last element in the list and make sure the new stage has a higher stage value than the last
        if(!list_stages.isEmpty()){

            // get the last stage and compare if the e
            int checker =0;

            for(Cards c: list_stages.get(list_stages.size()-1)){
                checker+= c.get_card_value();
            }

            return curr_stage_value >= checker;
        }

        return true;
    }

    // takes the sponsor player position
    // asks the sponsor player to build the stages and checks validity
    // if player cannot build quest, or votes not to return false then skip player turn
    // if true the round can start
    public boolean build_quest(int sponsor_player_pos, int card_value){

        // list in case a stage passes but another fails
        ArrayList<Cards> store_checker = new ArrayList<>();
        // scanner to pick card
        Scanner pick_card_per_stages = new Scanner(System.in);

        // dynamically creates the stages. the number of stages is equal to the Quest number
        while(list_stages.size() < card_value){

            // arrayList of stages dynamically
            ArrayList<Cards> each_stage = new ArrayList<>();

            // write the code to pick all the cards for a stage
            int chosen_card_position;

            while(true){

                // PRINTS THE HAND OF PLAYER AS HE IS ADDING CARDS TO STAGES
                lines();
                players[sponsor_player_pos].print_player_hand();

                System.out.println(String.format("Pick the card you want to add to stage from 1-%d, Pick 0 to submit Stage",(players[sponsor_player_pos].get_player_cards().size())));
                chosen_card_position = pick_card_per_stages.nextInt();

                if(chosen_card_position>=1 && chosen_card_position<=12){
                    lines();
                    System.out.println("Card added to Stage");

                    // add cards to stage
                    // add to temporary bin
                    // remove card from sponsor player hand
                    each_stage.add(players[sponsor_player_pos].get_player_cards().get(chosen_card_position-1));
                    store_checker.add(players[sponsor_player_pos].get_player_cards().get(chosen_card_position-1));
                    players[sponsor_player_pos].get_player_cards().remove(chosen_card_position-1);
                }
                if(chosen_card_position == 0){
                    lines();
                    System.out.println("Player is Done Choosing'");
                    break;
                }
            }

            // check if stage is accepted or do it again
            boolean stage_is_accepted = stage_selection_is_accepted(each_stage);
            String keep_playing;

            // if the stage is not accepted, ask to do the process again or break
            if(!stage_is_accepted) {
                lines();

                System.out.println(" after not accepted: Each Stage");
                for(Cards c : each_stage){
                    c.print_card();
                }

                System.out.println(" after not accepted:  Store Checker");
                for(Cards c : store_checker){
                    c.print_card();
                }


                // add all unaccepted cards back to player
                players[sponsor_player_pos].get_player_cards().addAll(store_checker);

                // clear store check
                // clear stage because it is not valid

                System.out.println("The Card Selection For Stage is Wrong. " +
                        "Do you want to try another stage selection or End game? yes/no: ");

                pick_card_per_stages.nextLine();
                keep_playing = pick_card_per_stages.nextLine();

                if (keep_playing.equals("no")) {
                    // add all removed cards from stages back to sponsors hand
                    players[sponsor_player_pos].get_player_cards().addAll(store_checker);

                    System.out.println("Sponsor ends try to sponsor");
                    return false;
                }

                if (keep_playing.equals("yes")) {
                    // add all removed cards from stages back to sponsors hand
                    store_checker.clear();

                }
                store_checker.clear();
                each_stage.clear();
            }

            // if the stage is accepted add it to the list if all stages
            if(stage_is_accepted){

                // prints stage
                lines();
                System.out.println("PRINT STAGE NUMBER: "+list_stages.size() );
                print_stages(each_stage, list_stages.size());

                // add stage to list of stages
                list_stages.add(each_stage);

            }
        }

        // if the size of list_stage != card_value
        // return false
                //  meaning player attempt to build quest unsuccessful
                // update player turn
        // return true   // quest successfully made
        if(list_stages.size()!= card_value){
            lines();
            System.out.println("Players attempt to sponsor quest is unsuccessful");

            // add all removed cards from stages back to sponsors hand
            players[sponsor_player_pos].get_player_cards().addAll(store_checker);
            store_checker.clear();
            return false;
        }

        System.out.println("Print all the stages to verify");

        // print all stages to verify this correct
        for(int i=0; i<list_stages.size(); i++){
            print_stages(list_stages.get(i), i);
        }

        get_stage_total();

        // if true add the cards from store bin to used adventure deck
        used_adventure_deck.addAll(store_checker);
        return true;
    }

    public ArrayList<Players> find_willing_participants(ArrayList<Players> willing_participants){

        Scanner will_partake = new Scanner(System.in);


        Iterator<Players> willing_participant_itr= willing_participants.iterator();

        while(willing_participant_itr.hasNext()){

            System.out.println("Player do you want to partake in this round: yes/no");
            String answer = will_partake.nextLine();
            Players willing_participant = willing_participant_itr.next();

            if(answer.equals("no")){
                System.out.println(String.format("Player%d will not participate", willing_participant.get_player_pos()));
                lines();

                willing_participant_itr.remove();
            }

            if(answer.equals("yes")){
                System.out.println(String.format("Player%d will participate", willing_participant.get_player_pos()));
                lines();
            }
       }

        return willing_participants;
    }

    public void get_stage_total(){

        for(int i=0; i<list_stages.size(); i++){

            int stage_total = 0;
            for(int j = 0; j<list_stages.get(i).size(); j++){
                stage_total+=list_stages.get(i).get(j).get_card_value();
            }
            stage_number.add(stage_total);
        }

        lines();

        for(Integer x: stage_number){
            System.out.println("Stage total: " + x);
        }
    }

    public void attack_Stage(ArrayList<Players> willing_participants, int quest_shields) {

        // got stage by stage then ask each willing_participants for their attack cards and get the attack total
        Scanner pick_cards = new Scanner(System.in);

        lines();
        System.out.println(" This is attack_stage function");


        for (int i =0; i<stage_number.size(); i++){


            //unreachable number
            ArrayList<Integer> lost_stage_participants = new ArrayList<>();

            System.out.println(String.format("Stage%d, Attack!!!!", (i+1)));

            // ask all willing participants for their attack cards
            lines();
            System.out.println("Asking willing participants to Attack: Stage"+ (i+1));
            lines();

            for (int k = 0; k < willing_participants.size(); k++) {

                int chosen_card_position;
                int attack_value = 0;

                while (true) {

                    willing_participants.get(k).print_player_hand();
                    System.out.println("Stage number -> "+ stage_number.get(i));
                    lines();

                    System.out.println(String.format("Pick the card to attack from 1-%d, or 0 to submit attack", willing_participants.get(k).get_player_cards().size()));
                    chosen_card_position = pick_cards.nextInt();

                    if (chosen_card_position >= 1 && chosen_card_position <= 12) {

                        /// add card value to attack total //print card
                        attack_value += willing_participants.get(k).get_player_cards().get(chosen_card_position-1).get_card_value();
                        willing_participants.get(k).get_player_cards().get(chosen_card_position-1).print_card();

                        // remove card from player hand and add to used adventure card list
                        used_adventure_deck.add(willing_participants.get(k).get_player_cards().remove(chosen_card_position-1));
                    }

                    if (chosen_card_position == 0) {
                        System.out.println(String.format("Player%d is done attacking ",willing_participants.get(k).get_player_pos()));
                        lines();
                        break;
                    }
                }

                // if players attack value for a stage < the stage value of the sponsor
                // remove them for willing participants
                // Cannot carry on playing
                if (attack_value < stage_number.get(i)){

                    //this list stores the positions of players that lost the stage.
                    // to be removed at the end of for loop (stage)
                    lost_stage_participants.add(k);
                    System.out.println(String.format("Player%d is done playing and will not be moving to the next stage", willing_participants.get(k).get_player_pos()));
                    lines();
                }
                else{
                    System.out.println(String.format("Player%d is moving to the next stage", willing_participants.get(k).get_player_pos()));
                    lines();
                }

                // at the last stage, if player attack is > stage value of sponsor,
                // add the quest value to winners shield total
                if(attack_value >= stage_number.get(i) && i== stage_number.size()-1) {
                    System.out.println(String.format("Player%d had won %d shields",willing_participants.get(k).get_player_pos(),quest_shields));
                    lines();
                    willing_participants.get(k).set_player_shields((willing_participants.get(k).get_player_shields())+quest_shields);
                }
            }

            // remove all willing participants that lost after stage is complete
            if(!lost_stage_participants.isEmpty()){ // someone lost a round
                for(int x: lost_stage_participants){
                    willing_participants.remove(x);
                }
            }

            if(willing_participants.isEmpty()){
                System.out.println("No more willing participants passed all the stages. ");
                break;
            }

        }
    }

    public boolean found_winners(){

        boolean flag = false;

        for(Players p: players){
            if(p.get_player_shields() >= 7){
                System.out.println(String.format("Player%d, has won with %d shields ",p.get_player_pos(),p.get_player_shields()));
                flag = true;
            }
        }
        return flag;
    }

    public void play_game(){

        int player_pos =0;

        // Currently drawn event card
        Cards curr_event_card;


        while((!found_winners())){

            // player in current position draws event card
            curr_event_card = draw_event_card();

            // print player and player position
            System.out.println(players[player_pos].get_player_name() + " current position: " + (player_pos+1));

            // print the card the player picked
            lines();
            System.out.print(players[player_pos].get_player_name() + " picked ");
            curr_event_card.print_card();


             // if the card is a plague card lose 2 shields
            if(curr_event_card.get_card_suit().equals("Plague")){
                lines();
                players[player_pos].print_player_hand();
                players[player_pos].set_player_shields(players[player_pos].get_player_shields()-2);

                lines();
                players[player_pos].print_player_hand();
            }

            // if the card drawn by current player is Queen's Favor pick 2 adventure cards
            // remember a player can only have 12 adventure cards
            // so the player will drop 2 adventure cards also. //add to used_ad..._deck
            if(curr_event_card.get_card_suit().equals("Queen's Favor")){
                lines();
                players[player_pos].print_player_hand();
                pick_two(player_pos);

                lines();
                players[player_pos].print_player_hand();
            }

            //if the card drawn by current player is Prosperity, everyone picks 2 adventure cards
            // everyone drops 2 adv cards and picks 2
            if(curr_event_card.get_card_suit().equals("Prosperity")){
                lines();
                for(int i =0; i<get_num_players(); i++){
                    pick_two(i);
                }
            }

            if(curr_event_card.get_card_suit().equals("Q")) {

                // print player's hand
                lines();
                players[player_pos].print_player_hand();

                // it is a players turn, do you skip turn or build quest
                int current_sponsor_pos = sponsor_quest(player_pos, curr_event_card.get_card_value());

                // if the sponsor_quest == -1
                // no player wants to sponsor
                // continue loop
                // skip player turn
                if(current_sponsor_pos == -1 ){
                    player_pos++;
                    player_pos = (player_pos) % get_num_players();
                    continue;
                }

                // and player start quest
                // A sponsor has been found print sponsors hand
                // build quests rn
                lines();
                System.out.printf("Player%d is the current sponsor\n", current_sponsor_pos+1);

                boolean was_quest_build_successful;
                was_quest_build_successful = build_quest(current_sponsor_pos, curr_event_card.get_card_value());

                // if was_quest_build_successful is false
                // update player turn and continue
                if(!was_quest_build_successful){
                    player_pos++;
                    player_pos = (player_pos) % get_num_players();
                    continue;
                }
                // play game
                else{

                    // contains list of all willing participants
                    // populate it with all possible participants (except sponsor)
                    // or they asked to be removed
                    ArrayList<Players> willing_participants = new ArrayList<>();

                    for (Players player : players) {
                        // add everyone except the sponsor
                        if (current_sponsor_pos != player.get_player_pos()-1) {
                            willing_participants.add(player);
                        }
                    }

                    lines();
                    System.out.println("Are you going to play quest:  ");
                    willing_participants = find_willing_participants(willing_participants);

                    lines();
                    System.out.println("Willing Participants For This Stage ");

                    // if there are willing participants, then draw a card
                    if(!willing_participants.isEmpty()){
                        for(Players p: willing_participants){

                            // draw adventure card
                            player_draw_adventure_card(p);
                        }
                    }

                    // players for round have been picked, pick winner etc.
                    // adventure card has been drawn also
                    attack_Stage(willing_participants, curr_event_card.get_card_value());

                    // quest winner has possibly been chosen,
                    // print player shields and player card size after attack
                    for(Players p: players){
                        System.out.println(String.format("Player%d has %d shields and %d cards",p.get_player_pos(),p.get_player_shields(),p.get_player_cards().size() ));
                    }
                    lines();

                    // checks if each player has less than 12 cards
                    // resizes player cards
                    for(Players p: players){

                        while (p.get_player_cards().size() < 12){
                            //if player hand size is < 12 add card to players hand
                            p.get_player_cards().add(used_adventure_deck.remove(0));
                        }
                    }

                    // this is after resizing player cards to 12
                    // adventure deck should be 52 after this
                    for(Players p: players){
                        System.out.println(String.format("Player%d has %d shields and %d cards",p.get_player_pos(),p.get_player_shields(),p.get_player_cards().size() ));
                    }
                    lines();
                }
            }

            player_pos = (player_pos) % get_num_players();

            // after every stage, clear everything that needs to be cleared
            stage_number.clear();
            list_stages.clear();

            // add all used cards to adventure deck, adventure deck should be 52.
            adventure_deck.addAll(used_adventure_deck);
            Collections.shuffle(adventure_deck);

            used_adventure_deck.clear();
            System.out.println("Adventure deck should be 52 --> " + adventure_deck.size());

            player_pos++;
        }
    }
}