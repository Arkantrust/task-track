package me.arkantrust.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import me.arkantrust.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {

        App.setRoot("secondary");

    }

}
