package edu.ntnu.idatt2001.cardgames;

import java.io.IOException;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * The type Extra controller.
 */
public class ExtraController {
    /**
     * The Deal button.
     */
    @FXML
    Button dealButton;
    /**
     * The Check button.
     */
    @FXML
    Button checkButton;
    /**
     * The Exit button.
     */
    @FXML
    Button exitButton;
    /**
     * The Shuffle button.
     */
    @FXML
    Button shuffleButton;
    /**
     * The Empty deck.
     */
    @FXML
    Text emptyDeck;
    /**
     * The Sum.
     */
    @FXML
    TextField sum;
    /**
     * The Flush.
     */
    @FXML
    TextField flush;
    /**
     * The Queen of spades.
     */
    @FXML
    TextField queenOfSpades;
    /**
     * The Hearts.
     */
    @FXML
    TextField hearts;
    /**
     * The Card 1.
     */
    @FXML
    ImageView card1;
    /**
     * The Card 2.
     */
    @FXML
    ImageView card2;
    /**
     * The Card 3.
     */
    @FXML
    ImageView card3;
    /**
     * The Card 4.
     */
    @FXML
    ImageView card4;
    /**
     * The Card 5.
     */
    @FXML
    ImageView card5;

    private DeckOfCards deckOfCards;
    private HandOfCards handOfCards;

    /**
     * Initializes the scene
     * sets checkButton and shuffleButton to disabled, so it's not useable when it shouldn't be
     * Instantiates an alert giving information on how to use the app
     *
     */
    @FXML
    public void initialize() {
        checkButton.setDisable(true);
        shuffleButton.setDisable(true);
        deckOfCards = new DeckOfCards();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setWidth(80);
        a.setHeight(800);
        a.setHeaderText("How to use app");
        a.setContentText("Please read the information given: \n Click 'Deal Hand' to get dealt 5 cards \n Click check hand to check your hand");
        a.show();
    }

    /**
     * Method for setting text and image fields to blank
     * Makes it easier to not have to write all these lines manually each time
     *
     * Uses try catch to catch illegal arguments
     *
     */
    private void setTextAndImgToBlank(){
        try {
            sum.setText("");
            flush.setText("");
            queenOfSpades.setText("");
            hearts.setText("");

            card1.setVisible(false);
            card2.setVisible(false);
            card3.setVisible(false);
            card4.setVisible(false);
            card5.setVisible(false);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    /**
     * Method for getting path to images. Made to make the steps of adding a new image easier.
     * @param cardAsString
     * @return
     */
    private String getPathToCardImages(String cardAsString) {
        return String.format("file:" +
                "src/main/resources/Images/%s", cardAsString) + ".png";
    }

    /**
     * Method for shuffling a new deck. This is used whenever deck is out of cards, so that you don't have to exit
     * application whenever deck runs out of cards
     *
     * Uses try catch to catch illegal arguments
     *
     * On click:
     * changes variable deckOfCards to new DeckOfCards
     * sets textfield saying that the deck is empty, to blank
     * disables checkHand button and shuffleDeck button
     * enables dealHand button
     * sets images of cards and text to blank
     * @throws IOException
     */
    @FXML
    private void shuffleNewDeck() throws IOException {
        try {
            deckOfCards = new DeckOfCards();
            emptyDeck.setText("");
            dealButton.setDisable(false);
            checkButton.setDisable(true);
            shuffleButton.setDisable(true);

            setTextAndImgToBlank();

        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    /**
     * Method for dealing a hand
     * Uses try catch to catch illegal arguments
     *
     * On click:
     * sets variable handOfCards to a new HandOfCards from an arraylist of playingcards, and deals a hand of cards
     * from deck of cards to that specific arraylist
     * disables dealHand button and shuffleDeck button
     * enables checkHand button
     * sets card images to visible
     * sets card images to new images, using path and cardAsString
     * sets textField to blank
     * @throws IOException
     */
    @FXML
    private void dealHand() throws IOException {
        try {
            this.handOfCards = new HandOfCards((ArrayList<PlayingCard>) deckOfCards.dealHand(5));
            checkButton.setDisable(false);
            dealButton.setDisable(true);
            shuffleButton.setDisable(true);

            card1.setVisible(true);
            card2.setVisible(true);
            card3.setVisible(true);
            card4.setVisible(true);
            card5.setVisible(true);

            card1.setImage(new Image(getPathToCardImages(handOfCards.getHandOfCards().get(0).getAsString())));
            card2.setImage(new Image(getPathToCardImages(handOfCards.getHandOfCards().get(1).getAsString())));
            card3.setImage(new Image(getPathToCardImages(handOfCards.getHandOfCards().get(2).getAsString())));
            card4.setImage(new Image(getPathToCardImages(handOfCards.getHandOfCards().get(3).getAsString())));
            card5.setImage(new Image(getPathToCardImages(handOfCards.getHandOfCards().get(4).getAsString())));

            sum.setText("");
            flush.setText("");
            queenOfSpades.setText("");
            hearts.setText("");
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    /**
     * method for checking hand
     * uses try catch to catch illegal arguments
     *
     * on click:
     * disables shuffleDeck button and checkHand button
     * enables dealHand button
     * sets text of textField to their respective values, depending on hand
     * checks if remaining cards in deckOfCards is more than 5,
     *  if not, it disables dealHand button,
     *  sets emptyDeck text to text explaining how deck of cards is empty
     *  enables shuffleButton
     *
     * @throws IOException
     */
    @FXML
    private void checkHand() throws IOException {
        try {
            checkButton.setDisable(true);
            dealButton.setDisable(false);
            shuffleButton.setDisable(true);
            sum.setText("" + handOfCards.sumOfFaces());
            flush.setText(handOfCards.isFlush());
            queenOfSpades.setText(handOfCards.hasQueenOfSpades());
            hearts.setText(handOfCards.hasHearts());

            if (deckOfCards.getNumberOfCards() < 5) {
                dealButton.setDisable(true);
                emptyDeck.setText("Deck of cards is empty!");
                shuffleButton.setDisable(false);
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    /**
     * Method for exit button
     *
     * on click:
     * closes stage
     * @throws IOException
     */
    @FXML
    private void exit() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
