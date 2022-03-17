package edu.ntnu.idatt2001.cardgames;

import java.util.*;

public class HandOfCards {
    private ArrayList<PlayingCard> handOfCards;
    private int faceSum;
    private boolean isFlush, hasQueenOfSpades;
    private DeckOfCards deckOfCards;

    public HandOfCards(ArrayList<PlayingCard> givenHand) {
        handOfCards = new ArrayList<>();
        handOfCards.addAll(givenHand);
    }

    public int getHandOfCardsSize() {
        int handOfCardsSize = 0;
        for (int i = 0; i < handOfCards.size(); i++) {
            handOfCardsSize++;
        }
        return getHandOfCardsSize();
    }

    public int sumOfFaces() {
        return handOfCards.stream().mapToInt(PlayingCard::getFace).sum();
    }

    public String isFlush() {
        if (handOfCards.stream().filter(p -> p.getSuit() == 'S').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'H').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'D').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'C').count() >= 5) {
            return "Flush";
        }
        return "No flush";
    }
}
