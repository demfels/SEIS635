/**
 * Sample Skeleton for "FXML.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package mediamaster;

import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class FXMLController {

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

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader

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


    // Handler for Button[fx:id="buttonRefresh"] onAction
    @FXML
    void handleButtonAction(ActionEvent event) {
        // handle the event here
        ObservableList<String> imageItems =FXCollections.observableArrayList ("Picture1", "Picture2", "PIctture3", "Picture4");
        listImage.setItems(imageItems);
        ObservableList<String> videoItems =FXCollections.observableArrayList ("video1", "video2", "video3", "video4");
        listVideo.setItems(videoItems);
        ObservableList<String> audioItems =FXCollections.observableArrayList ("audio1", "audio2", "audio3", "audio4");
        listAudio.setItems(audioItems);
    }

    // Handler for Button[fx:id="buttonOpen"] onMouseReleased
    @FXML
    void openButtonEvent(MouseEvent event) {
        // handle the event here
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert audioPane != null : "fx:id=\"audioPane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert buttonOpen != null : "fx:id=\"buttonOpen\" was not injected: check your FXML file 'FXML.fxml'.";
        assert buttonRefresh != null : "fx:id=\"buttonRefresh\" was not injected: check your FXML file 'FXML.fxml'.";
        assert imagePane != null : "fx:id=\"imagePane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert imageViewWindow != null : "fx:id=\"imageViewWindow\" was not injected: check your FXML file 'FXML.fxml'.";
        assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file 'FXML.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listAudio != null : "fx:id=\"listAudio\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listImage != null : "fx:id=\"listImage\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listVideo != null : "fx:id=\"listVideo\" was not injected: check your FXML file 'FXML.fxml'.";
        assert menuEditImport != null : "fx:id=\"menuEditImport\" was not injected: check your FXML file 'FXML.fxml'.";
        assert menuFileClose != null : "fx:id=\"menuFileClose\" was not injected: check your FXML file 'FXML.fxml'.";
        assert textMediaDirectory != null : "fx:id=\"textMediaDirectory\" was not injected: check your FXML file 'FXML.fxml'.";
        assert videoPane != null : "fx:id=\"videoPane\" was not injected: check your FXML file 'FXML.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
