/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediamaster;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class MediaMaster extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);

        
        stage.setScene(scene);
        stage.show();
        
        
        /*testing area*/
        //Scene sceneVideo = new Scene(new Group(), 1024, 768);
        //stage.setScene(sceneVideo);
        // Name and display the Stage.
        //stage.setTitle("Media Master");
        //stage.show();
        //String source ="file:///C:/MediaMaster/sample_mpeg4.mp4";
        //Media media = new Media(source);
        //MediaPlayer player = new MediaPlayer(media);
        //player.setAutoPlay(true);
        //MediaView view = new MediaView(player);
        //((Group) sceneVideo.getRoot()).getChildren().add(view);
        // Create the player and set to play automatically.
        
        
        
        //End TEsting//
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
