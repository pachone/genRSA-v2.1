/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genrsa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author rdiazarr
 */
public class GenRSA extends Application {
    
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
    
    

    @Override
    public void init() throws Exception {
        notifyPreloader(new ProgressNotification(0.15d));
        Thread.sleep(150);
        notifyPreloader(new ProgressNotification(0.30d));
        Thread.sleep(150);
        notifyPreloader(new ProgressNotification(0.45d));
        Thread.sleep(150);
        notifyPreloader(new ProgressNotification(0.60d));
        Thread.sleep(150);
        notifyPreloader(new ProgressNotification(0.75d));
        Thread.sleep(150);
        notifyPreloader(new ProgressNotification(1.0d));
        Thread.sleep(100);
        notifyPreloader(new StateChangeNotification(StateChangeNotification.Type.BEFORE_START));
    }


    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
                        
            Scene scene = new Scene(root);
            
            primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);

            primaryStage.setScene(scene);
            primaryStage.setTitle("genRSA - Generación de claves RSA");   
            primaryStage.getIcons().add(new Image("file:resources/icono/genRSA.png"));
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(GenRSA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(GenRSA.class, (java.lang.String[])null);
    }
    
}
