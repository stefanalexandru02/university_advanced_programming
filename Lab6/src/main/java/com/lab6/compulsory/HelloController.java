package com.lab6.compulsory;

import com.lab6.compulsory.helpers.Point;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    Spinner<Integer> numberOfDotsSpinner;

    @FXML
    Canvas drawingCanvas;

    @FXML
    StackPane canvasParent;

    @FXML
    public void initialize() {
        numberOfDotsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 1, 1));

        drawingCanvas.heightProperty().bind(canvasParent.heightProperty());
        drawingCanvas.widthProperty().bind(canvasParent.widthProperty());
    }

    @FXML
    protected void CreateNewGame() {
        int points = numberOfDotsSpinner.getValue();
        var height = drawingCanvas.getHeight();
        var width = drawingCanvas.getWidth();

        double radius = height < width ? height : width;
        radius = radius / 1.15;

        GraphicsContext gc = drawingCanvas.getGraphicsContext2D() ;
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());

        gc.setFill(Color.BLACK);

        double mainCircleX = (width-radius)/2;
        double mainCircleY = (height-radius)/2;

        gc.setLineWidth(0.1);
        gc.strokeOval(mainCircleX, mainCircleY, radius, radius);

        double realRadius = drawingCanvas.getWidth() - 2 * mainCircleX;
        realRadius = realRadius / 2;

        List<Point> pointsList = new ArrayList<>();

        double slice = 2 * Math.PI / points;
        for (int i = 0; i < points; i++)
        {
            double angle = slice * i;

            double centerX = drawingCanvas.getWidth() / 2;
            double centerY = drawingCanvas.getHeight() / 2;

            double xPos = realRadius * Math.cos(angle) + centerX - 10;
            double yPos = realRadius * Math.sin(angle) + centerY - 10;

            gc.fillOval( xPos,  yPos, 20, 20);

            pointsList.add(new Point(xPos + 10, yPos + 10));
        }

        gc.setLineWidth(0.2);
        for(int i = 0; i < pointsList.size(); i++)
        {
            for(int j = 0; j < pointsList.size(); j++)
            {
                if(i != j)
                {
                    gc.strokeLine(pointsList.get(i).getX(), pointsList.get(i).getY(),
                            pointsList.get(j).getX(), pointsList.get(j).getY());
                }
            }
        }
    }

    @FXML
    protected void LoadGame()
    {

    }

    @FXML
    protected void SaveGame()
    {

    }

    @FXML
    protected void ResetGame()
    {

    }

    @FXML
    protected void ExitGame()
    {

    }
}