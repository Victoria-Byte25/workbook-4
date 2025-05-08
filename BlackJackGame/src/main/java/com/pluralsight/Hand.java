package com.pluralsight;

import java.util.*;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotalValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank().equals("A")) aceCount++;
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public String toString() {
        return cards.toString() + " (Total: " + getTotalValue() + ")";
    }

}
