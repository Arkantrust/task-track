package me.arkantrust;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("primary"));
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Task Tracker");
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show();

    }

    public static void setRoot(String fxml) throws IOException {

        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {

        return new FXMLLoader(App.class.getResource(fxml + ".fxml")).load();

    }

    public static void main(String[] args) {

        launch();

    }

}
