package ir.ac.kntu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Scanner;

public class JavaFxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        root.setStyle("-fx-border-width: 0 0 5 0; -fx-border-style: dotted;");

        //TODO your code goes here
        // try to separate logic from GUI

        RecursiveGUI recursiveGUI = new RecursiveGUI();
        // Setting stage properties
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the width of pane:");
        int width=scanner.nextInt();
        System.out.println("Enter the height of pane:");
        int height=scanner.nextInt();
        Scene scene = new Scene(root, width, height, Color.rgb(203,203,203));
        root.setMaxHeight(height);
        root.setMaxWidth(width);
        System.out.println("Enter the angle:");
        int angle=scanner.nextInt();
        System.out.println("Enter the length of diameter:");
        int diameter=scanner.nextInt();
        System.out.println("Enter the number of depth :");
        int iterate=scanner.nextInt();
        recursiveGUI.shape(root,iterate,diameter,angle,width,height);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Recursion in JavaFX!");
        stage.setScene(scene);
        stage.show();
    }
}