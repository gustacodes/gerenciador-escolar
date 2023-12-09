package com.gerenciador.gerenciadorescolar.view;

import com.gerenciador.gerenciadorescolar.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class Telas {

    Stage stage = new Stage();
    private static Stage stg;

    public void telas(String telas, String titulo) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(telas + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}