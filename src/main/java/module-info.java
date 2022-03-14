module edu.ntnu.idatt2001.cardgames {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens edu.ntnu.idatt2001.cardgames to javafx.fxml;
    exports edu.ntnu.idatt2001.cardgames;
}