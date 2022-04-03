import org.junit.jupiter.api.*;

import edu.ntnu.idatt2001.cardgames.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {
    private static DeckOfCards deckOfCards;

    /**
     * Before running all other test methods, it runs this method for initializing
     * creates a new deckOfCards
     */
    @BeforeAll
    static void init(){
        deckOfCards = new DeckOfCards();
    }

    @Test
    @DisplayName("Test that checks correct amount of cards in deck")
    public void getCards_listWithCardsGiven_ExpectedCorrectSize(){
        assertEquals(52, deckOfCards.getCardsList().size());
    }

    @Test
    @DisplayName("Test that checks if correct number of cards is dealt")
    public void dealHand_positiveNumberGiven_ShouldDealCorrectNumberOfCards(){
        ArrayList<PlayingCard> handOfCards = (ArrayList<PlayingCard>) deckOfCards.dealHand(5);
        assertEquals(5, handOfCards.size());
    }

    @Test
    @DisplayName("Test that checks if exception is thrown if argument is <0")
    public void dealHand_NegativeNumbergiven_ExceptionThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            deckOfCards.dealHand(-1);
        });
    }

}