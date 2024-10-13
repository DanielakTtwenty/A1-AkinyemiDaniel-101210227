package org.example;

public class Cards {

    private final String card_suit;
    private final int card_value;
    private final int card_number;

    // constructor
    public Cards(String card_suit, int card_value, int card_number){
        this.card_suit = card_suit;
        this.card_value = card_value;
        this.card_number = card_number;
    }

    // getters
    public String get_card_suit() {
        return card_suit;
    }
    public int get_card_value() {
        return card_value;
    }

    public int get_card_number() {
        return card_number;
    }

    // print out card
    public void print_card(){
//        System.out.println("Card Name: " + card_suit + " Card Value: " + card_value + " Card Number: " + card_number);
        System.out.println( card_suit + card_value  + " Id: " + card_number );
    }
}
