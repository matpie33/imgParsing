package com.supercode.app.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class MainPoint extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
        Canvas canvas = new Canvas(300,300);

        Group group = new Group();
        Scene scene = new Scene(group, 100, 100);
        stage.setScene(scene);
        group.getChildren().add(canvas);


        setColors(canvas);
    }

    private void setColors(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        PixelWriter pixelWriter = gc.getPixelWriter();
        for (int i=0; i<100; i++){
            pixelWriter.setColor(i,0, Color.RED);
        }
        for (int i=0; i<100; i++){
            pixelWriter.setColor(i,3, Color.YELLOW);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
