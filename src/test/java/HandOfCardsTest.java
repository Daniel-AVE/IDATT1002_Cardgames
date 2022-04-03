import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import edu.ntnu.idatt2001.cardgames.*;

import static org.junit.jupiter.api.Assertions.*;

public class HandOfCardsTest {

    private static HandOfCards handOfCards;

    /**
     * Before running any other method, it runs this method
     * creates a manual deck of cards to be used for testing
     * adds all playingcards to an arraylist handOfCards
     */
    @BeforeAll
    static void init(){
        PlayingCard p1 = new PlayingCard('S',4);
        PlayingCard p2 = new PlayingCard('D',7);
        PlayingCard p3 = new PlayingCard('H',1);
        PlayingCard p4 = new PlayingCard('H',7);
        PlayingCard p5 = new PlayingCard('C',12);
        handOfCards = new HandOfCards(new ArrayList<PlayingCard>(Arrays.asList(p1,p2,p3,p4,p5)));


    }

    /**
     * Nests multiple different tests under one category for correct arguments
     */
    @Nested
    class testWithCorrectArguments{

        @Test
        @DisplayName("Test that checks correct sum of cards")
        public void sumCards_listWithCards_CorrectSumReturned(){
            assertEquals(31,handOfCards.sumOfFaces());
        }

        @Test
        @DisplayName("Test that checks if hearts is present")
        public void checkIfContainsHearts_listWithCards_ShouldReturnCardsWithHeart(){
            assertEquals("H1 H7", handOfCards.hasHearts());
        }
        @Test
        @DisplayName("Test that check if Queen of spades is present")
        public void checkIfQueenSpadesPresent_listWithCards_ShouldReturnNoIfNotInList(){
            assertEquals("NO", handOfCards.hasQueenOfSpades());
        }

        @Test
        @DisplayName("Test that checks if a flush is present")
        public void checkForFlush_listWithCards_ShouldReturnNoIfNotInList(){
            assertEquals("No flush", handOfCards.isFlush());
        }
    }

    /**
     * Nests tests under one category for false arguments
     */
    @Nested
    class testWithFalseArguments{
        @Test
        @DisplayName("Test that checks if constructor throws exception when the arraylist is empty")
        public void constructor_emptyArrayListGiven_ThrowingException(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new HandOfCards(new ArrayList<PlayingCard>());
            });

        }
    }

}