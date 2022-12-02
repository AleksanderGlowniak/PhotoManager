package com.mycompany.photomanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class PhotoManager extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws InterruptedException {
    // Create a button and place it in the scene
    Button btOK = new Button("Wait");
    Scene scene = new Scene(btOK, 400, 250);
    primaryStage.setTitle("Loading"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
  
    
    primaryStage.close();
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) { 
    launch(args);
    
  }
}