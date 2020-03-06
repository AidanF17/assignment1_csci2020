package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestmentCalculator extends Application{

    public double getInvestment(TextField invest, TextField year, TextField interest){
		//does calculation based on text fields
        double investDouble = Double.parseDouble(invest.getText());
        double yearDouble = Double.parseDouble(year.getText());
        double interestDouble = Double.parseDouble(interest.getText());
        double monthlyInterest = (interestDouble/100)/12;
        double exponent = Math.pow(1 + monthlyInterest, yearDouble*12);
        double futureValue = exponent * investDouble;
        System.out.println(futureValue);
        return futureValue;
    }
    public void start(Stage primaryStage) throws Exception {
        TextField investment = new TextField();
        TextField years = new TextField();
        TextField interest = new TextField();
        TextField value = new TextField();
        value.setEditable(false);

        Button b = new Button("Calculate!");
        b.setOnAction(event -> {
            try{
				//calculates and sets the text to value
                value.setText(Double.toString(getInvestment(investment, years, interest)));
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setPadding(new Insets(10,10,10,10));

        pane.add(investment, 1,0);
        pane.add(new Label("Investment Value:"), 0,0);

        pane.add(years, 1,1);
        pane.add(new Label("Years:"), 0,1);

        pane.add(interest, 1,2);
        pane.add(new Label("Annual Interest Rate:"), 0,2);

        pane.add(value, 1,3);
        pane.add(new Label("Future Value:"), 0,3);
        pane.add(b, 0,4);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Investment Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
