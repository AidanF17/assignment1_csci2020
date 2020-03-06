package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
public class DisplayThreeCards extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
		//random number generation
		int randNum = (int) (Math.random() * 52 + 1);
        int randNum1 = (int) (Math.random() * 52 + 1);
        int randNum2 = (int) (Math.random() * 52 + 1);
        /*
        String url = "C:\\Users\\Aidan\\IdeaProjects\\DisplayThreeCards\\images\\" + Integer.toString(randNum) + ".png";
        String url1 = "C:\\Users\\Aidan\\IdeaProjects\\DisplayThreeCards\\images\\" + Integer.toString(randNum1) + ".png";
        String url2 = "C:\\Users\\Aidan\\IdeaProjects\\DisplayThreeCards\\images\\" + Integer.toString(randNum2) + ".png";
        */
		//images from image folder containing cards
        String url = "images/" + Integer.toString(randNum) + ".png";
        String url1 = "images/" + Integer.toString(randNum1) + ".png";
        String url2 = "images/" + Integer.toString(randNum2) + ".png";
		
		//File streams to get the file
        FileInputStream image = new FileInputStream(url);
        FileInputStream image1 = new FileInputStream(url1);
        FileInputStream image2 = new FileInputStream(url2);

		//store the three cards in an array
        Image[] cards = new Image[3];
        cards[0] = new Image(image);
        cards[1] = new Image(image1);
        cards[2]= new Image(image2);
		
		//create 3 image view for each card
        ImageView view = new ImageView(cards[0]);
        ImageView view1 = new ImageView(cards[1]);
        ImageView view2 = new ImageView(cards[2]);

		//Hbox lays out flowpane would be good too
        HBox pane = new HBox();
        pane.getChildren().addAll(view, view1, view2);

		//add pane create scene
        Scene scene = new Scene(pane);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Three Cards");
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
