package edu.ntnu.idatt2001.cardgames;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("You just clicked a button for no reason. Great work!");
    }
}