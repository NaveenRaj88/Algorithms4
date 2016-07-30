package com.chap2.sec_2_1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Naveen on 29-07-2016.
 */
public class DeckSort_Ex_2_1_13 {


    public static void main(String[] args) {
        int[] suits = {1, 2, 3, 4};
        int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Card[] deck = new Card[52];
        int counter =0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[counter++] = new Card(suits[i],ranks[j]);
            }
        }
        Arrays.sort(deck, new DeckSorter());
        System.out.println(Arrays.toString(deck));

    }


}

class DeckSorter implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getSuit()< o2.getSuit()){
            return -1;
        }else if(o1.getSuit()> o2.getSuit()){
            return 1;
        }else{
            if(o1.getRank()< o2.getRank()){
                return -1;
            }else if(o1.getRank()> o2.getRank()){
                return 1;
            }
            return 0;
        }
    }
}

class Card {
    private int suit;

    private int rank;

    Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "S="+getSuit()+":R="+getRank();
    }
}