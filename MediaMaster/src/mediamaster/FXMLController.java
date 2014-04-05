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
import javafx.scene.control.TitledPane;


public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="audioPane"
    private TitledPane audioPane; // Value injected by FXMLLoader

    @FXML // fx:id="buttonRefresh"
    private Button buttonRefresh; // Value injected by FXMLLoader

    @FXML // fx:id="imagePane"
    private TitledPane imagePane; // Value injected by FXMLLoader

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="listAudio"
    private ListView<?> listAudio; // Value injected by FXMLLoader

    @FXML // fx:id="listImage"
    private ListView<String> listImage; // Value injected by FXMLLoader

    @FXML // fx:id="listVideo"
    private ListView<?> listVideo; // Value injected by FXMLLoader

    @FXML // fx:id="videoPane"
    private TitledPane videoPane; // Value injected by FXMLLoader



    // Handler for Button[fx:id="buttonRefresh"] onAction
    @FXML
    void handleButtonAction(ActionEvent event) {
        // handle the event here
        ObservableList<String> items =FXCollections.observableArrayList ("Single", "Double", "Suite", "Family App");
        listImage.setItems(items);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert audioPane != null : "fx:id=\"audioPane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert buttonRefresh != null : "fx:id=\"buttonRefresh\" was not injected: check your FXML file 'FXML.fxml'.";
        assert imagePane != null : "fx:id=\"imagePane\" was not injected: check your FXML file 'FXML.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listAudio != null : "fx:id=\"listAudio\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listImage != null : "fx:id=\"listImage\" was not injected: check your FXML file 'FXML.fxml'.";
        assert listVideo != null : "fx:id=\"listVideo\" was not injected: check your FXML file 'FXML.fxml'.";
        assert videoPane != null : "fx:id=\"videoPane\" was not injected: check your FXML file 'FXML.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}
