/*
 * Based on tutorial code from Oracle Site: http://docs.oracle.com/javase/8/javafx/JFXMD.pdf
 * @author daniel
 */

package mediamaster;

import java.util.Observable;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
public class MediaControl extends BorderPane {
    private MediaPlayer mp;
    private MediaView mediaView;
    private final boolean repeat = false;
    private boolean stopRequested = false;
    private boolean atEndOfMedia = false;
    private Duration duration;
    private Slider timeSlider;
    private Label playTime;
    private Slider volumeSlider;
    private HBox mediaBar;
    public MediaControl(final MediaPlayer mp) {
        this.mp = mp;
        setStyle("-fx-background-color: #bfc2c7;");
        mediaView = new MediaView(mp);
        Pane mvPane = new Pane() {};
        mvPane.getChildren().add(mediaView);
        mvPane.setStyle("-fx-background-color: black;"); 
        setCenter(mvPane);
        mediaBar = new HBox();
        mediaBar.setAlignment(Pos.CENTER);
        mediaBar.setPadding(new Insets(5, 10, 5, 10));
        BorderPane.setAlignment(mediaBar, Pos.CENTER);
        final Button playButton = new Button(">");
        
        playButton.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Status status = mp.getStatus();

             if (status == Status.UNKNOWN || status == Status.HALTED)
             {
             // don't do anything in these states
             return;
             }

             if ( status == Status.PAUSED
             || status == Status.READY
             || status == Status.STOPPED)
             {
             // rewind the movie if we're sitting at the end
             if (atEndOfMedia) {
             mp.seek(mp.getStartTime());
             atEndOfMedia = false;
             }
             mp.play();
             } else {
             mp.pause();
             }
             }
         });
            mp.setOnPlaying(new Runnable() {
            public void run() {
            if (stopRequested) {
            mp.pause();
            stopRequested = false;
            } else {
            playButton.setText("||");
            }
            }
            });
            mp.setOnPaused(new Runnable() {
            public void run() {
            System.out.println("onPaused");
            playButton.setText(">");
            }
            });
            mp.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
            mp.setOnEndOfMedia(new Runnable() {
            public void run() {
            if (!repeat) {
            playButton.setText(">");
            stopRequested = true;
            atEndOfMedia = true;
            }
            }
            });

        mediaBar.getChildren().add(playButton);
        setBottom(mediaBar); 
        // Add spacer
        Label spacer = new Label(" ");
        mediaBar.getChildren().add(spacer);
    }    
}