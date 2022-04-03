package edu.ntnu.idatt2001.cardgames;

import java.util.*;
import java.util.stream.Collectors;

public class HandOfCards {
    private ArrayList<PlayingCard> handOfCards;
    private int faceSum;
    private boolean hasQueenOfSpades;
    private DeckOfCards deckOfCards;

    public HandOfCards(ArrayList<PlayingCard> givenHand) {
        if (givenHand == null || givenHand.isEmpty()) {
            throw new IllegalArgumentException("Hand cannot be empty or null");
        }
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
        return (handOfCards.stream().filter(p -> p.getSuit() == 'S').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'H').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'D').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'C').count() >= 5) ? "Flush" : "No flush";
    }

    public String hasQueenOfSpades() {
        return handOfCards.stream().anyMatch(p -> p.getSuit() == 'S' && p.getFace() == 12) ? "YES" : "NO";
    }

    public String hasHearts() {
        ArrayList<PlayingCard> sortedHearts =  handOfCards.stream().filter(p -> p.getSuit() == 'H').collect(Collectors.toCollection(ArrayList::new));
        return sortedHearts.size() == 0 ? "No hearts" : sortedHearts.stream().map(PlayingCard::toString).collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard playingcard : handOfCards) {
            sb.append(playingcard.toString()).append("  ");
        }
        return sb.toString();
    }
}
