package io.zipcoder.casino;

import java.util.ArrayList;

public class Hand {
    private ArrayList <Card> hand;

    public Hand(){
       hand= new ArrayList<Card>();
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public void addCard(ArrayList<Card> cards){
        hand.addAll(cards);
    }

    public void clearHand(){
        hand.clear();
    }

    public Card removeCard(Card.Rank rank){
        Card card=null;
        for(int i=0; i<hand.size(); i++)
            if(hand.get(i).equals(rank))
               card= hand.remove(i);
        return card;
    }

    public String toString(){
        String cardsInHand=hand.get(0).toString();
        for(int i=1; i<hand.size(); i++)
            cardsInHand+="\n"+hand.get(i).toString();
        return cardsInHand;
    }

    public ArrayList<Card> getHand() {
        return hand;

    }
}