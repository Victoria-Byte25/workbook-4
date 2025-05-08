package com.pluralsight;

public class Player {
    private final String name;
    private final Hand hand = new Hand();

    public Player(String name) {
        this.name = name;
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.getTotalValue();
    }

    public String getName() {
        return name;
    }

    public String showHand() {
        return hand.toString();
    }
}
