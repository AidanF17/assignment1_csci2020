package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.*;

public class DragPointsOnCircleWork extends Application{
	//setting ring
    Circle circle = new Circle();
    Circle inner = new Circle();
	//creating points
    Circle p1 = new Circle();
    Circle p2 = new Circle();
    Circle p3 = new Circle();
	//triangle lines
    Line c1 = new Line();
    Line c2 = new Line();
    Line c3 = new Line();
	//angle collection
    double angle[] = {0.0, 0.0, 0.0};

    @Override
    public void start(Stage primaryStage) throws Exception {
        //defining circles
		p1.setFill(GREEN);
        p2.setFill(RED);
        p3.setFill(BLUE);

        p1.setCenterX(25.0f);
        p2.setCenterX(100.0f);
        p3.setCenterX(75.0f);

        p1.setCenterY(75.0f);
        p2.setCenterY(75.0f);
        p3.setCenterY(10.0f);

        p1.setRadius(10.0f);
        p2.setRadius(10.0f);
        p3.setRadius(10.0f);
		//bounding lines to circle to form a triangle
        setLines();
		
		//adding handlers to each point for movement
        p1.setOnMouseDragged(pointMouseDragged);
        p2.setOnMouseDragged(pointMouseDragged);
        p3.setOnMouseDragged(pointMouseDragged);
		//adding handlers for angles
        p1.setOnMousePressed(pointMousePressed);
        p2.setOnMousePressed(pointMousePressed);
        p3.setOnMousePressed(pointMousePressed);
		//add this to pane
        Pane pointPane = new Pane();
        pointPane.getChildren().addAll(p1, p2, p3, c1, c2, c3);

        //Ring
        inner.setCenterX(75.0f);
        circle.setCenterX(75.0f);
        circle.setCenterY(75.0f);
        inner.setCenterY(75.0f);
        inner.setRadius(45.0f);
        circle.setRadius(50.0f);

        circle.setFill(BLACK);
        inner.setFill(WHITE);
		
		//stack pane for ring 
        StackPane p = new StackPane();
        inner.setVisible(true);
        circle.setVisible(true);

        p.getChildren().addAll(circle, inner, pointPane);
        p.setMaxSize(400, 400);

        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Drag Point On Circle");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void getAngles(){
		//could not get the points to move around circle
		//getAngles was to get the angle and help reset the points to mouse value 
		//based lines to move around perimeter
        double a = new Point2D(p3.getCenterX(), p3.getCenterY()).
                distance(p2.getCenterX(), p2.getCenterY());
        double b = new Point2D(p3.getCenterX(), p3.getCenterY()).
                distance(p1.getCenterX(), p1.getCenterY());
        double c = new Point2D(p2.getCenterX(), p2.getCenterY()).
                distance(p1.getCenterX(), p1.getCenterY());

        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));
    }
    public void setLines(){
		//connecting lines to seperate points
        c1.startXProperty().bind(p1.centerXProperty());
        c1.startYProperty().bind(p1.centerYProperty());
        c1.endXProperty().bind(p2.centerXProperty());
        c1.endYProperty().bind(p2.centerYProperty());
		//connecting lines to seperate points
        c2.startXProperty().bind(p1.centerXProperty());
        c2.startYProperty().bind(p1.centerYProperty());
        c2.endXProperty().bind(p3.centerXProperty());
        c2.endYProperty().bind(p3.centerYProperty());

        c3.startXProperty().bind(p2.centerXProperty());
        c3.startYProperty().bind(p2.centerYProperty());
        c3.endXProperty().bind(p3.centerXProperty());
        c3.endYProperty().bind(p3.centerYProperty());
        //X := originX + cos(angle)*radius;
        //Y := originY + sin(angle)*radius;
    }
    EventHandler<MouseEvent> pointMousePressed = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
			//when press on point get angles
            System.out.println("Pressed");
            System.out.println(angle[0]);
            getAngles();
        }
    };

    EventHandler<MouseEvent> pointMouseDragged = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
			//When drag on point reset the circle that is dragged to mouse position
            System.out.println("Dragged");
            ((Circle)(e.getSource())).setCenterX(e.getX());
            ((Circle)(e.getSource())).setCenterY(e.getY());
            ((Circle)(e.getSource())).getCenterX();
            System.out.println(((Circle)(e.getSource())).getCenterY());
            setLines();
        }
    };

    public static void main(String[] args){
        launch(args);
    }
}
