package edu.ntnu.idatt2001.cardgames;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class MainController {
    @FXML
    private void switchToExtra() throws IOException {
        Application.setRoot("extra");
    }
}