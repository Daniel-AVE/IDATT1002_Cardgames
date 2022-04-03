package edu.ntnu.idatt2001.cardgames;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Hand of cards.
 */
public class HandOfCards {
    private ArrayList<PlayingCard> handOfCards;
    private int faceSum;
    private boolean hasQueenOfSpades;
    private DeckOfCards deckOfCards;

    /**
     * Instantiates a new Hand of cards.
     *
     * @param givenHand the given hand
     */
    public HandOfCards(ArrayList<PlayingCard> givenHand) {
        if (givenHand == null || givenHand.isEmpty()) {
            throw new IllegalArgumentException("Hand cannot be empty or null");
        }
        handOfCards = new ArrayList<>();
        handOfCards.addAll(givenHand);
    }

    /**
     * Gets hand of cards.
     *
     * @return the hand of cards
     */
    public ArrayList<PlayingCard> getHandOfCards() {
        return handOfCards;
    }

    /**
     * Gets hand of cards size.
     *
     * @return the hand of cards size
     */
    public int getHandOfCardsSize() {
        int handOfCardsSize = 0;
        for (int i = 0; i < handOfCards.size(); i++) {
            handOfCardsSize++;
        }
        return getHandOfCardsSize();
    }

    /**
     * Sum of faces int.
     *
     * streams through arraylist handOfCards, and converts value of getFace to int, and sums those together
     *
     * @return the int
     */
    public int sumOfFaces() {
        return handOfCards.stream().mapToInt(PlayingCard::getFace).sum();
    }

    /**
     * Is flush string.
     * Uses String to return a text field, saving work of having to convert boolean to String later on
     *
     * streams and filters through handOfCards for all suits, and checks if there are 5 or more of that suit on hand
     * if yes: returns Flush
     * if no: returns No flush
     *
     * @return the string
     */
    public String isFlush() {
        return (handOfCards.stream().filter(p -> p.getSuit() == 'S').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'H').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'D').count() >= 5 ||
                handOfCards.stream().filter(p -> p.getSuit() == 'C').count() >= 5) ? "Flush" : "No flush";
    }

    /**
     * Has queen of spades string.
     * Checks if hand contains queen of spades
     *
     * streams through arraylist, and looks for anything that matches the suit S, and face 12.
     * If it matches: returns "YES"
     * if no match: returns "NO"
     *
     *
     * @return the string
     */
    public String hasQueenOfSpades() {
        return handOfCards.stream().anyMatch(p -> p.getSuit() == 'S' && p.getFace() == 12) ? "YES" : "NO";
    }

    /**
     * Has hearts string.
     * Checks hand of cards for any cards of hearts
     *
     * Creates a new arraylist where we can put our cards of hearts
     * streams through arraylist handOfCards, and filters out all suits of 'H', and adds that to a collection as a new card
     *
     * for return:
     * if arraylist sortedHearts = 0, it means there are no hearts. Therefore it returns "No hearts" if that happens
     * if arraylist is not empty, it streams through that arraylist, and gets the toString in PlayingCard for each object
     * and joins them in the collection, using a space as delimiter
     *
     * @return the string
     */
    public String hasHearts() {
        ArrayList<PlayingCard> sortedHearts = handOfCards.stream().filter(p -> p.getSuit() == 'H').collect(Collectors.toCollection(ArrayList::new));
        return sortedHearts.size() == 0 ? "No hearts" : sortedHearts.stream().map(PlayingCard::toString).collect(Collectors.joining(" "));
    }

    /**
     * toString method
     * uses StringBuilder to build a string to return
     * iterates through playingcards in handOfCards
     * appends each playingcard toString from Playingcard to this toString, and appends a space behind that for each iteration
     * @return returns toString of StringBuilder
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard playingcard : handOfCards) {
            sb.append(playingcard.toString()).append("  ");
        }
        return sb.toString();
    }
}
