package edu.ntnu.idatt2001.cardgames;

import java.io.IOException;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExtraController {
    @FXML
    Button dealButton;
    @FXML
    Button checkButton;
    @FXML
    Button exitButton;
    @FXML
    Label cardDisplay;
    @FXML
    Label resultDisplay;

    private DeckOfCards deckOfCards;
    private HandOfCards handOfCards;

    @FXML
    public void initialize() {
        checkButton.setDisable(true);
        deckOfCards = new DeckOfCards();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setWidth(80);
        a.setHeight(800);
        a.setHeaderText("How to use app");
        a.setContentText("Please read the information given: \n Click 'Deal Hand' to get dealt 5 cards \n Click check hand to check your hand");
        a.show();
    }

    @FXML
    private void dealHand() throws IOException {
        this.handOfCards = new HandOfCards((ArrayList<PlayingCard>) deckOfCards.dealHand(5));
        deckOfCards.dealHand(5);
        cardDisplay.setText(handOfCards.toString());
        checkButton.setDisable(false);
        dealButton.setDisable(true);
        resultDisplay.setText("");
    }

    @FXML
    private void checkHand() throws IOException {
        checkButton.setDisable(true);
        dealButton.setDisable(false);
        StringBuilder sb = new StringBuilder();
        sb.append("Hand: ");
        sb.append(handOfCards.toString()).append("\n");
        sb.append("Sum of cards: ");
        sb.append(handOfCards.sumOfFaces()).append("\n");
        sb.append("Hearts: ");
        sb.append(handOfCards.hasHearts()).append("\n");
        sb.append("Queen of spades? ");
        sb.append(handOfCards.hasQueenOfSpades()).append("\n");
        sb.append("Flush? ");
        sb.append(handOfCards.isFlush()).append("\n");
        resultDisplay.setText(sb.toString());
    }

    @FXML
    private void exit() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
