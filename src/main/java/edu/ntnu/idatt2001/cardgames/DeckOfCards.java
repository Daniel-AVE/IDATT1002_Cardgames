package edu.ntnu.idatt2001.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import edu.ntnu.idatt2001.cardgames.*;

/**
 * The type Deck of cards.
 */
public class DeckOfCards {
    private final char[] suits = { 'S', 'H', 'D', 'C' };
    private ArrayList<PlayingCard> cardsList;

    /**
     * Instantiates a new Deck of cards.
     */
    public DeckOfCards() {
        this.cardsList = new ArrayList<>();
        fillDeckWithCards();
    }

    /**
     * Gets cards list.
     *
     * @return the cards list
     */
    public ArrayList<PlayingCard> getCardsList() {
        return cardsList;
    }

    /**
     * Fill deck with cards.
     * Iterates through all available suits. For each suit, it iterates through numbers 1 to 14 for cards,
     * and adds cards to arraylist cardsList, but suit and face.
     */
    public void fillDeckWithCards() {
        for (char suit : suits) {
            for (int i = 1; i < 14; i++) {
                cardsList.add(new PlayingCard(suit, i));
            }
        }
    }

    /**
     * Gets number of cards.
     *
     * @return the number of cards
     */
    public int getNumberOfCards() {
        int numberOfCards = 0;
        for (int i = 0; i < cardsList.size(); i++) {
            numberOfCards++;
        }
        return numberOfCards;
    }

    /**
     * Deal hand array list.
     *
     * Creates a new arraylist to hold the hand of cards
     * throws exception when there aren't enough cards left in deck to deal
     * Uses a for loop which iterates n amount of times
     * Uses random to get a random card from cardslist, and adds this to the returnDeck arraylist
     * removes that card from deck after each iteration
     *
     * @param n the number of cards to be dealt
     * @return the array list
     */
    public ArrayList<PlayingCard> dealHand(int n) {
        Random random = new Random();
        ArrayList<PlayingCard> returnDeck = new ArrayList<>();

        if (getNumberOfCards() < n) {
            throw new IllegalArgumentException("There aren't enough cards to deal");
        }

        if (n < 0) {
            throw new IllegalArgumentException("Number of cards to be dealt cannot be 0 or lower!");
        }

        for (int i = 0; i < n; i++) {
            PlayingCard card = cardsList.get(random.nextInt(cardsList.size()));
            returnDeck.add(new PlayingCard(card.getSuit(), card.getFace()));
            cardsList.remove(card);
        }
        return returnDeck;
    }
}
