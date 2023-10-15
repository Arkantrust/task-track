package me.arkantrust.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import me.arkantrust.App;

public class TaskController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskListView;

    @FXML
    private void switchToSecondary() throws IOException {

        App.setRoot("secondary");

    }

    @FXML
    private void addTask() {

        String task = taskInput.getText().trim();

        if (!task.isEmpty()) {

            taskListView.getItems().add(task);
            taskInput.clear();

        }

    }

}
