package com.pluralsight;

import java.util.*;


public class BlackJackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // Deal 2 cards to each player
        for (Player player : players) {
            player.receiveCard(deck.dealCard());
            player.receiveCard(deck.dealCard());
        }

        System.out.println("\n--- Player Hands ---");
        Player winner = null;
        int highestScore = 0;

        for (Player player : players) {
            int score = player.getScore();
            System.out.println(player.getName() + ": " + player.showHand());

            if (score > highestScore && score <= 21) {
                highestScore = score;
                winner = player;
            }
        }

        System.out.println("\n--- Result ---");
        if (winner != null) {
            System.out.println(" The Winner is: " + winner.getName() + " with " + highestScore + " points!");
        } else {
            System.out.println("No winner. Yikes!");
        }

        scanner.close();
    }
}
