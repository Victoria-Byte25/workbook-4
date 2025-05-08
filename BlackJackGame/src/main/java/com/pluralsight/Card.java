package com.pluralsight;

public class Card {
    private final String suit;
    private final String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        switch (rank) {
            case "A": return 11;
            case "K": case "Q": case "J": return 10;
            default: return Integer.parseInt(rank);
        }
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public String getRank() {
        return rank;
    }
}
