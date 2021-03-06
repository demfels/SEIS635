/**
 * @author daniel arnott
 **/

package mediamaster;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;


public class FXMLController {
    String source;
    Media media = null;
    //Media media = new Media(source);
    MediaCollection mediaCollection = new MediaCollection();
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="audioPane"
    private TitledPane audioPane; // Value injected by FXMLLoader

    @FXML // fx:id="buttonOpen"
    private Button buttonOpen; // Value injected by FXMLLoader

    @FXML // fx:id="buttonRefresh"
    private Button buttonRefresh; // Value injected by FXMLLoader

    @FXML // fx:id="imagePane"
    private TitledPane imagePane; // Value injected by FXMLLoader

    @FXML // fx:id="imageViewWindow"
    private ImageView imageViewWindow; // Value injected by FXMLLoader

    //@FXML // fx:id="infoLabel"
    //private Label infoLabel; // Value injected by FXMLLoader

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="listAudio"
    private ListView<String> listAudio; // Value injected by FXMLLoader

    @FXML // fx:id="listImage"
    private ListView<String> listImage; // Value injected by FXMLLoader

    @FXML // fx:id="listVideo"
    private ListView<String> listVideo; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditImport"
    private MenuItem menuEditImport; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileClose"
    private MenuItem menuFileClose; // Value injected by FXMLLoader

    @FXML // fx:id="textMediaDirectory"
    private TextField textMediaDirectory; // Value injected by FXMLLoader

    @FXML // fx:id="videoPane"
    private TitledPane videoPane; // Value injected by FXMLLoader

       //
    // Handler for Button[fx:id="buttonRefresh"] onAction
    @FXML
    void handleButtonAction(ActionEvent event) {
        // handle the event here
        refreshMedia();
    }
    @FXML
    void clearSelection(MouseEvent event) {
        listVideo.getSelectionModel().clearSelection();
        listAudio.getSelectionModel().clearSelection();
        listImage.getSelectionModel().clearSelection();
        
    }

    @FXML
    void importFileEvent(ActionEvent event){
        MediaImporter importer = new MediaImporter();
        try {
            importer.showFileChooser(textMediaDirectory.getText());
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Handler for Button[fx:id="buttonOpen"] onMouseReleased
    @FXML
    void openButtonEvent(MouseEvent event) {
        String selectedVideo = listVideo.getSelectionModel().getSelectedItem();
        String selectedAudio = listAudio.getSelectionModel().getSelectedItem();
        String selectedImage = listImage.getSelectionModel().getSelectedItem();
        File selectedFile=null;
        if(selectedVideo!=null && selectedVideo.length()>1){
           selectedFile  = new File(selectedVideo);
           media = new Media(selectedFile.toURI().toASCIIString());
            MediaWindow mediaWindow = new MediaWindow();
            mediaWindow.showVideo(media);
        }
        else if(selectedAudio!=null && selectedAudio.length()>1){
           selectedFile  = new File(selectedAudio);
           media = new Media(selectedFile.toURI().toASCIIString());
           MediaWindow mediaWindow = new MediaWindow();
           mediaWindow.showVideo(media);
        }
        else if(selectedImage!=null && selectedImage.length()>1){
           selectedFile  = new File(selectedImage);
           Image image = new Image((selectedFile.toURI().toASCIIString()));
           ImageWindow imageWindow = new ImageWindow();
           imageWindow.showImage(image);
        }
        else{
            media=null;
            System.out.println("[DEBUG] Error, no selected item.");
        }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert audioPane != null : "fx:id=\"audioPane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert buttonOpen != null : "fx:id=\"buttonOpen\" was not injected: check your FXML file 'FXML.fxml'.";
        assert buttonRefresh != null : "fx:id=\"buttonRefresh\" was not injected: check your FXML file 'FXML.fxml'.";
        assert imagePane != null : "fx:id=\"imagePane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert imageViewWindow != null : "fx:id=\"imageViewWindow\" was not injected: check your FXML file 'FXML.fxml'.";
        //assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file 'FXML.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listAudio != null : "fx:id=\"listAudio\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listImage != null : "fx:id=\"listImage\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listVideo != null : "fx:id=\"listVideo\" was not injected: check your FXML file 'FXML.fxml'.";
        assert menuEditImport != null : "fx:id=\"menuEditImport\" was not injected: check your FXML file 'FXML.fxml'.";
        assert menuFileClose != null : "fx:id=\"menuFileClose\" was not injected: check your FXML file 'FXML.fxml'.";
        assert textMediaDirectory != null : "fx:id=\"textMediaDirectory\" was not injected: check your FXML file 'FXML.fxml'.";
        assert videoPane != null : "fx:id=\"videoPane\" was not injected: check your FXML file 'FXML.fxml'.";
        
        // Initialize your logic here: all @FXML variables will have been injected
        textMediaDirectory.setText("C:\\MediaMaster");
        setDirectory();
        refreshMedia();


    }
    private void setDirectory(){
        File startDirectory = new File(textMediaDirectory.getText());
        startDirectory.mkdirs();
    }
    private void refreshMedia(){
        setDirectory();
        String mediaDirectory = textMediaDirectory.getText();
        //Set audio files to list
        FileSearch fs = new FileSearch();
        ArrayList<File> list = fs.listAudio(mediaDirectory);
        String audioFiles="";
        ObservableList<String> audioItems =FXCollections.observableArrayList (audioFiles);
        audioItems.clear();
        for (File fil : list)
        {   
            MediaFile mediaFile;
            mediaFile = new MediaFile("Audio",fil.getName(),fil);
            mediaCollection.addAudioFile(mediaFile);
            audioItems.add(fil.getPath());
        }
        
        listAudio.setItems(audioItems);
        

        //Set Images to list
        FileSearch fs2 = new FileSearch();
        list = fs2.listImage(mediaDirectory);
        String imageFiles="";
        ObservableList<String> imageItems =FXCollections.observableArrayList (imageFiles);
        imageItems.clear();
        for (File fil : list)
        {   
            MediaFile mediaFile;
            mediaFile = new MediaFile("Image",fil.getName(),fil);
            mediaCollection.addImageFile(mediaFile);
            imageItems.add(fil.getPath());
        }
        
        listImage.setItems(imageItems);
        
        
        //Set video files to list
        FileSearch fs3 = new FileSearch();
        list = fs3.listVideo(mediaDirectory);
        String videoFiles="";
        ObservableList<String> videoItems = FXCollections.observableArrayList (videoFiles);
        videoItems.clear();
        for (File fil : list)
        {   
            MediaFile mediaFile;
            mediaFile = new MediaFile("Video",fil.getName(),fil);
            mediaCollection.addVideoFile(mediaFile);
            videoItems.add(fil.getPath());
        }
        listVideo.setItems(videoItems);
    }
    

}
