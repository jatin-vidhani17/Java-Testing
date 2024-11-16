//  Write a program to store a deck of 52 cards in a linked list in random sequence using a Random class
// object. You can represent a card as a two-character string—”1C” for the ace of clubs, “JD” for the
// jack of diamonds, and so on. Output the cards from the linked list as four hands of 13 cards.


import java.util.*;

class DeckOfCards {
    public static void main(String[] args) {
        String[] suits = {"C", "D", "H", "S"}; 
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        LinkedList<String> deck = new LinkedList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }

        Collections.shuffle(deck, new Random());

        List<String> hand1 = new ArrayList<>();
        List<String> hand2 = new ArrayList<>();
        List<String> hand3 = new ArrayList<>();
        List<String> hand4 = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            String card = deck.get(i);
            if (i % 4 == 0) {
                hand1.add(card);
            } else if (i % 4 == 1) {
                hand2.add(card);
            } else if (i % 4 == 2) {
                hand3.add(card);
            } else {
                hand4.add(card);
            }
        }

        System.out.println("Hand 1: " + hand1);
        System.out.println("Hand 2: " + hand2);
        System.out.println("Hand 3: " + hand3);
        System.out.println("Hand 4: " + hand4);
    }
}
/*

Output : 

Hand 1: [KH, 9H, 5C, 10D, 2H, 6C, QS, 3D, JD, 8S, 7H, 4S, 6S]
Hand 2: [KC, 5H, 9S, AH, 8D, 7D, 4H, 3H, JC, QH, 10C, 2D, 8C]
Hand 3: [AS, 10S, KS, 3C, 6H, 9D, 5S, 7C, 10H, 4C, 2C, 7S, 3S]
Hand 4: [2S, 8H, JD, 10D, 4D, 5D, 9C, 6D, 4S, QD, QS, 3D, KH]

*/