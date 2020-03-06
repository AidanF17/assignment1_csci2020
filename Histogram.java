package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Histogram extends Application {
    public static int[] alphaCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0};
    @Override
    public void start(Stage primaryStage) throws Exception {
		//Creation of chart
		//file chooser opens windows file system select file from there
        FileChooser fileChooser = new FileChooser();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
		
		
		//creation of text field
        BarChart barChart = new BarChart(xAxis, yAxis);
        TextField searchBox = new TextField();
        searchBox.setText("C:\\Users\\Aidan\\IdeaProjects\\DisplayThreeCards\\Textfiles\\lol.txt");
		
		
        Button button = new Button("Select File");
        button.setOnAction(e -> {
			//when button activated windows file system opens
			//selected file is added to textbox 
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            searchBox.setText(selectedFile.toString());
            alphaCount = getAlphaCount(new File(searchBox.getText()));
            barChart.getData().remove(0 );
			//removes previous data^
            barChart.getData().add(updateChart());

			//updates the chart^
        });

        button.setAlignment(Pos.BOTTOM_RIGHT);
        searchBox.setAlignment(Pos.BOTTOM_LEFT);
        HBox fileChoose = new HBox();

        fileChoose.getChildren().add(button);
        fileChoose.getChildren().add(searchBox);


        //alphaCount = getAlphaCount(new File("C:\\Users\\Aidan\\IdeaProjects\\DisplayThreeCards\\Textfiles\\lol.txt"));
        XYChart.Series dataSeries1 = updateChart();
        barChart.getData().add(dataSeries1);

        VBox pane = new VBox();
        pane.getChildren().add(barChart);
        pane.getChildren().add(fileChoose);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Histogram");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public XYChart.Series updateChart(){
		//used to reset the charts data and add new data from windows file system
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.getData().add(new XYChart.Data("A", alphaCount[0]));
        dataSeries1.getData().add(new XYChart.Data("B", alphaCount[1]));
        dataSeries1.getData().add(new XYChart.Data("C", alphaCount[2]));
        dataSeries1.getData().add(new XYChart.Data("D", alphaCount[3]));
        dataSeries1.getData().add(new XYChart.Data("E", alphaCount[4]));
        dataSeries1.getData().add(new XYChart.Data("F", alphaCount[5]));
        dataSeries1.getData().add(new XYChart.Data("G", alphaCount[6]));
        dataSeries1.getData().add(new XYChart.Data("H", alphaCount[7]));
        dataSeries1.getData().add(new XYChart.Data("I", alphaCount[8]));
        dataSeries1.getData().add(new XYChart.Data("J", alphaCount[9]));
        dataSeries1.getData().add(new XYChart.Data("K", alphaCount[10]));
        dataSeries1.getData().add(new XYChart.Data("L", alphaCount[11]));
        dataSeries1.getData().add(new XYChart.Data("M", alphaCount[12]));
        dataSeries1.getData().add(new XYChart.Data("N", alphaCount[13]));
        dataSeries1.getData().add(new XYChart.Data("O", alphaCount[14]));
        dataSeries1.getData().add(new XYChart.Data("P", alphaCount[15]));
        dataSeries1.getData().add(new XYChart.Data("Q", alphaCount[16]));
        dataSeries1.getData().add(new XYChart.Data("R", alphaCount[17]));
        dataSeries1.getData().add(new XYChart.Data("S", alphaCount[18]));
        dataSeries1.getData().add(new XYChart.Data("T", alphaCount[19]));
        dataSeries1.getData().add(new XYChart.Data("U", alphaCount[20]));
        dataSeries1.getData().add(new XYChart.Data("V", alphaCount[20]));
        dataSeries1.getData().add(new XYChart.Data("W", alphaCount[21]));
        dataSeries1.getData().add(new XYChart.Data("X", alphaCount[22]));
        dataSeries1.getData().add(new XYChart.Data("Y", alphaCount[23]));
        dataSeries1.getData().add(new XYChart.Data("Z", alphaCount[24]));
        return dataSeries1;
    }
    public static int[] getAlphaCount(File file){
        System.out.println("ALPHA CALL");
		//counts each letter in alphabet based on file
        int[] alphaCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0};
        try {
			//javaio used to read file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                for (int i = 0; i < st.length(); i++) {
                    if(st.charAt(i) == 'a' || st.charAt(i) == 'A'){
                        alphaCount[0]++;
                    }else if(st.charAt(i) == 'b' || st.charAt(i) == 'B'){
                        alphaCount[1]++;
                    }else if(st.charAt(i) == 'c' || st.charAt(i) == 'C'){
                        alphaCount[2]++;
                    }else if(st.charAt(i) == 'd' || st.charAt(i) == 'D'){
                        alphaCount[3]++;
                    }else if(st.charAt(i) == 'e' || st.charAt(i) == 'E'){
                        alphaCount[4]++;
                    }else if(st.charAt(i) == 'f' || st.charAt(i) == 'F'){
                        alphaCount[5]++;
                    }else if(st.charAt(i) == 'g' || st.charAt(i) == 'G'){
                        alphaCount[6]++;
                    }else if(st.charAt(i) == 'H' || st.charAt(i) == 'H'){
                        alphaCount[7]++;
                    }else if(st.charAt(i) == 'i' || st.charAt(i) == 'I'){
                        alphaCount[8]++;
                    }else if(st.charAt(i) == 'j' || st.charAt(i) == 'J'){
                        alphaCount[9]++;
                    }else if(st.charAt(i) == 'k' || st.charAt(i) == 'K'){
                        alphaCount[10]++;
                    }else if(st.charAt(i) == 'l' || st.charAt(i) == 'L'){
                        alphaCount[11]++;
                    }else if(st.charAt(i) == 'm' || st.charAt(i) == 'M'){
                        alphaCount[12]++;
                    }else if(st.charAt(i) == 'n' || st.charAt(i) == 'N'){
                        alphaCount[13]++;
                    }else if(st.charAt(i) == 'o' || st.charAt(i) == 'O'){
                        alphaCount[14]++;
                    }else if(st.charAt(i) == 'p' || st.charAt(i) == 'P'){
                        alphaCount[15]++;
                    }else if(st.charAt(i) == 'q' || st.charAt(i) == 'Q'){
                        alphaCount[16]++;
                    }else if(st.charAt(i) == 'r' || st.charAt(i) == 'R'){
                        alphaCount[17]++;
                    }else if(st.charAt(i) == 's' || st.charAt(i) == 'S'){
                        alphaCount[18]++;
                    }else if(st.charAt(i) == 't' || st.charAt(i) == 'T'){
                        alphaCount[19]++;
                    }else if(st.charAt(i) == 'u' || st.charAt(i) == 'U'){
                        alphaCount[20]++;
                    }else if(st.charAt(i) == 'v' || st.charAt(i) == 'V'){
                        alphaCount[21]++;
                    }else if(st.charAt(i) == 'w' || st.charAt(i) == 'W'){
                        alphaCount[22]++;
                    }else if(st.charAt(i) == 'x' || st.charAt(i) == 'X'){
                        alphaCount[23]++;
                    }else if(st.charAt(i) == 'y' || st.charAt(i) == 'Y'){
                        alphaCount[24]++;
                    }else if(st.charAt(i) == 'z' || st.charAt(i) == 'Z'){
                        alphaCount[25]++;
                    }else{
                        System.out.println("non-Alpha");
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return alphaCount;
    }

    public static void main(String[] args) throws Exception{
        launch(args);
    }
}
