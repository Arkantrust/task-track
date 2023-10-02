package me.arkantrust.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import me.arkantrust.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
    
        App.setRoot("primary");
    
    }

}
