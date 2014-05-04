/*
 * @author daniel arnott
 */

package mediamaster;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class MediaWindow extends Application{
    private Stage stage = new Stage();
    public void showVideo(Media media){
        Group root = new Group();
        //media = new Media("file:///C:/MediaMaster/mpeg4Sample.mp4");
        MediaPlayer player;
        player = new MediaPlayer(media);
        MediaView mediaView = new MediaView(player);
        mediaView.setFitWidth(800);
        mediaView.setPreserveRatio(true);
        mediaView.setSmooth(true);
        mediaView.setCache(true);
        player.setAutoPlay(true);
        player.play();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 800, 450, Color.BLACK);
        stage.setScene(scene);
        stage.show();
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
