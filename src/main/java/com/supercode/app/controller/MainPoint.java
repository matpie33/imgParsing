package com.supercode.app.controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class MainPoint extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        Canvas canvas = new Canvas();

        Group group = new Group();
        Scene scene = new Scene(group, 100, 100);
        stage.setScene(scene);
        group.getChildren().add(canvas);

        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        PixelWriter pixelWriter = graphicsContext2D.getPixelWriter();
        pixelWriter.setColor(0,0, Color.RED);
        pixelWriter.setColor(1,0, Color.RED);
        pixelWriter.setColor(2,0, Color.RED);
        pixelWriter.setColor(3,0, Color.RED);
    }



    public static void main(String[] args) {
        launch(args);
    }

}
