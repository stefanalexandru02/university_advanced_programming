package com.lab6.compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab6.compulsory.helpers.Point;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class HelloController {
    Game gameInstance = new Game();

    @FXML
    Spinner<Integer> numberOfDotsSpinner;

    @FXML
    Canvas drawingCanvas;

    @FXML
    StackPane canvasParent;

    /**
     * Initialize the view by setting up the spinner settings
     * And binding the canvas height and width of the canvas to its parent
     */
    @FXML
    public void initialize() {
        numberOfDotsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 1, 1));

        drawingCanvas.heightProperty().bind(canvasParent.heightProperty());
        drawingCanvas.widthProperty().bind(canvasParent.widthProperty());
    }

    /**
     * Initialize a new game based on the selected number of points
     */
    @FXML
    protected void CreateNewGame() {
        int points = numberOfDotsSpinner.getValue();

        gameInstance.pointsCount = points;
        gameInstance.getLines().clear();

        drawGame();
    }

    @FXML
    protected void LoadGame()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON Files", "*.json")
        );
        File file = fileChooser.showOpenDialog(new Stage());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            gameInstance = objectMapper.readValue(new File(file.getPath()), Game.class);
            numberOfDotsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(gameInstance.pointsCount, 24, 1, 1));
            drawGame(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void SaveGame()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON Files", "*.json")
        );
        File file = fileChooser.showSaveDialog(new Stage());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(file.getPath()), gameInstance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void SavePNG() {
        WritableImage writableImage = new WritableImage((int) canvasParent.getWidth(), (int) canvasParent.getHeight());
        canvasParent.snapshot(null, writableImage);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG Files", "*.png")
        );
        File file = fileChooser.showSaveDialog(new Stage());
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        } catch (Exception s) { throw new RuntimeException(s); }
    }

    @FXML
    protected void ResetGame()
    {
        CreateNewGame();
    }

    @FXML
    protected void ExitGame()
    {
        exit(0);
    }

    /**
     * Draw game on the screen
     */
    void drawGame()
    {
        drawGame(false);
    }

    /**
     * Draw game on the screen with isLoading attribute
     * If isLoading is set to true, it does not add new lines to game instance
     */
    void drawGame(boolean isLoading)
    {
        var height = drawingCanvas.getHeight();
        var width = drawingCanvas.getWidth();

        double radius = height < width ? height : width;
        radius = radius / 1.15;

        GraphicsContext gc = drawingCanvas.getGraphicsContext2D() ;
        // Clear out the current content
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());

        gc.setFill(Color.BLACK);

        double mainCircleX = (width-radius)/2;
        double mainCircleY = (height-radius)/2;

        gc.setLineWidth(0.1);
        gc.strokeOval(mainCircleX, mainCircleY, radius, radius);

        double realRadius = drawingCanvas.getWidth() - 2 * mainCircleX;
        realRadius = realRadius / 2;

        List<Point> pointsList = new ArrayList<>();

        // Calculate slices for each point
        double slice = 2 * Math.PI / gameInstance.pointsCount;
        for (int i = 0; i < gameInstance.pointsCount; i++)
        {
            double angle = slice * i;

            double centerX = drawingCanvas.getWidth() / 2;
            double centerY = drawingCanvas.getHeight() / 2;

            double xPos = realRadius * Math.cos(angle) + centerX - 10;
            double yPos = realRadius * Math.sin(angle) + centerY - 10;

            gc.fillOval( xPos,  yPos, 20, 20);

            if(isLoading == false) {
                pointsList.add(new Point(xPos + 10, yPos + 10, i));
            } else {
                gameInstance.getLines().forEach(line -> {
                    if(!pointsList.contains(line.getP1()))
                        pointsList.add(line.getP1());
                    if(!pointsList.contains(line.getP2()))
                        pointsList.add(line.getP2());
                });
            }
        }

        Pane overlay = new Pane();

        // Generate lines connecting points
        gc.setLineWidth(0.2);
        for(int i = 0; i < pointsList.size(); i++)
        {
            for(int j = i+1; j < pointsList.size(); j++)
            {
                if(i != j)
                {
                    Line line = new Line(pointsList.get(i).getX(), pointsList.get(i).getY(),
                            pointsList.get(j).getX(), pointsList.get(j).getY());
                    line.setStrokeWidth(4);
                    line.setStroke(Color.BLACK);

                    if(isLoading == false || gameInstance.getLines().size() == 0) {
                        gameInstance.getLines().add(new com.lab6.compulsory.helpers.Line(pointsList.get(i), pointsList.get(j)));
                    }
                    else {
                        Point p1 = pointsList.get(i);
                        Point p2 = pointsList.get(j);

                        for(int h = 0; h < gameInstance.getLines().size(); h++)
                        {
                            if(gameInstance.getLines().get(h).HasPoint(p1) &&
                                    gameInstance.getLines().get(h).HasPoint(p2))
                            {
                                if(gameInstance.getLines().get(h).isColored())
                                {
                                    if(gameInstance.getLines().get(h).isRed()) {
                                        line.setStroke(Color.RED);
                                    } else {
                                        line.setStroke(Color.BLUE);
                                    }
                                }
                            }
                        }
                    }

                    int finalI = i;
                    int finalJ = j;
                    line.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            Line source = (Line)mouseEvent.getSource();
                            if(gameInstance.isNextRed) {
                                source.setStroke(Color.RED);
                            } else {
                                source.setStroke(Color.BLUE);
                            }

                            Point p1 = pointsList.get(finalI);
                            Point p2 = pointsList.get(finalJ);

                            for(int h = 0; h < gameInstance.getLines().size(); h++)
                            {
                                if(gameInstance.getLines().get(h).HasPoint(p1) &&
                                        gameInstance.getLines().get(h).HasPoint(p2))
                                {
                                    gameInstance.getLines().get(h).setRed(gameInstance.isNextRed ? true : false);
                                    gameInstance.getLines().get(h).setColored(true);
                                }
                            }

                            gameInstance.isNextRed = !gameInstance.isNextRed;

                            checkAnyoneWon();
                        }
                    });

                    overlay.getChildren().add(line);
                }
            }
        }

        for(int i = 0; i < pointsList.size(); i++)
        {
            overlay.getChildren().add(new Circle(pointsList.get(i).getX(), pointsList.get(i).getY(), 15));
        }

        canvasParent.getChildren().clear();
        canvasParent.getChildren().addAll(drawingCanvas, overlay);
    }

    private boolean checkAnyoneWon()
    {
        for(int i = 0; i < gameInstance.getLines().size(); i++)
        {
            for(int j = i; j < gameInstance.getLines().size(); j++)
            {
                for(int k = j; k < gameInstance.getLines().size(); k++)
                {
                    var l1 = gameInstance.getLines().get(i);
                    var l2 = gameInstance.getLines().get(j);
                    var l3 = gameInstance.getLines().get(k);

                    if(!l1.isColored() || !l2.isColored() || !l3.isColored())
                    {
                        continue;
                    }

                    if(!(l1.isRed() && l2.isRed() && l3.isRed()))
                    {
                        continue;
                    }

                    if(!l1.isRed() && !l2.isRed() && !l3.isRed())
                    {
                        continue;
                    }

                    if(l1 == l2 || l2 == l3 || l3 == l1)
                    {
                        continue;
                    }

                    HashMap<Pair<Double, Double>, Integer> points = new HashMap<>();

                    points.put(l1.getP1().asPair(), points.containsKey(l1.getP1().asPair()) ? points.get(l1.getP1().asPair()) + 1 : 1);
                    points.put(l1.getP2().asPair(), points.containsKey(l1.getP2().asPair()) ? points.get(l1.getP2().asPair()) + 1 : 1);

                    points.put(l2.getP1().asPair(), points.containsKey(l2.getP1().asPair()) ? points.get(l2.getP1().asPair()) + 1 : 1);
                    points.put(l2.getP2().asPair(), points.containsKey(l2.getP2().asPair()) ? points.get(l2.getP2().asPair()) + 1 : 1);

                    points.put(l3.getP1().asPair(), points.containsKey(l3.getP1().asPair()) ? points.get(l3.getP1().asPair()) + 1 : 1);
                    points.put(l3.getP2().asPair(), points.containsKey(l3.getP2().asPair()) ? points.get(l3.getP2().asPair()) + 1 : 1);

                    if(points.size() == 3)
                    {
                        boolean ok = true;
                        if(points.get(l1.getP1().asPair()) != 2 || points.get(l1.getP2().asPair()) != 2)
                        {
                            ok = false;
                        }
                        if(points.get(l2.getP1().asPair()) != 2 || points.get(l2.getP2().asPair()) != 2)
                        {
                            ok = false;
                        }
                        if(points.get(l3.getP1().asPair()) != 2 || points.get(l3.getP2().asPair()) != 2)
                        {
                            ok = false;
                        }

                        if(ok)
                        {
                            Alert a = new Alert(Alert.AlertType.NONE);
                            a.setAlertType(Alert.AlertType.INFORMATION);
                            if(l1.isRed())
                            {
                                System.out.println("RED WON");
                                a.setTitle("RED WON");
                                a.setContentText("RED WON");
                                a.show();

                                ResetGame();

                                return true;
                            }
                            else {
                                System.out.println("BLUE WON");
                                a.setTitle("BLUE WON");
                                a.setContentText("BLUE WON");
                                a.show();

                                ResetGame();

                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}