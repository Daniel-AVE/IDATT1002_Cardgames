package edu.ntnu.idatt2001.cardgames;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type Application.
 */
public class Application extends javafx.application.Application {
    private static Scene scene;

    /**
     * Method for starting the application.
     *
     * sets minimum and maximum width and height to make the visuals of the app for pleasing.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"));
        stage.setScene(scene);
        stage.setMinHeight(651);
        stage.setMinWidth(646);
        stage.setMaxHeight(651);
        stage.setMaxWidth(646);
        stage.show();
    }

    /**
     * Sets root.
     *
     * @param fxml the fxml
     * @throws IOException the io exception
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /*
    loads FXML
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
        }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }
}