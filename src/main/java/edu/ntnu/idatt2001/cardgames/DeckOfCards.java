package edu.ntnu.idatt2001.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import edu.ntnu.idatt2001.cardgames.*;

public class DeckOfCards {
    private final char[] suits = { 'S', 'H', 'D', 'C' };
    private ArrayList<PlayingCard> cardsList;

    public DeckOfCards() {
        this.cardsList = new ArrayList<>();
        fillDeckWithCards();
    }

    public ArrayList<PlayingCard> getCardsList() {
        return cardsList;
    }

    public void fillDeckWithCards() {
        for (char suit : suits) {
            for (int i = 1; i < 14; i++) {
                cardsList.add(new PlayingCard(suit, i));
            }
        }
    }

    public int getNumberOfCards() {
        int numberOfCards = 0;
        for (int i = 0; i < cardsList.size(); i++) {
            numberOfCards++;
        }
        return numberOfCards;
    }

    public void shuffleDeck() {
        Collections.shuffle(cardsList);
    }

    public ArrayList<PlayingCard> dealHand(int n) {
        Random random = new Random();
        ArrayList<PlayingCard> returnDeck = new ArrayList<>();
        shuffleDeck();

        if (getNumberOfCards() < n) {
            throw new IllegalArgumentException("There aren't enough cards to deal");
        }

        for (int i = 0; i < n; i++) {
            PlayingCard card = cardsList.get(random.nextInt(cardsList.size()));
            returnDeck.add(new PlayingCard(card.getSuit(), card.getFace()));
            cardsList.remove(card);
        }
        return returnDeck;
    }
}
