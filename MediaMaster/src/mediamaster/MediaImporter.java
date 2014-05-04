/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediamaster;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class MediaImporter extends Application{
    private Stage stage = new Stage();
    public void showFileChooser(String argDestination) throws IOException{
        String destination=argDestination;
        File fileDestination=new File(destination);
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Pick Import Directory");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(stage);
        
        
        
        File dir = selectedDirectory;
        File[] matchingFiles = dir.listFiles();
        for (File fil : matchingFiles)
        {   
            String filePath = fil.getPath();
            if(filePath.contains(".mp4") || filePath.contains(".mp3") || filePath.contains(".wav") || filePath.contains(".bmp") || filePath.contains(".png") || filePath.contains(".jpg")){
                System.out.println("[DEBUG] Importer");
                System.out.println("[DEBUG] source file:"+fil.getPath());
                
                File target = new File(destination+"//"+fil.getName());
                System.out.println("[DEBUG] target file:"+fil.getPath());
                Files.move(fil.toPath(), target.toPath(), REPLACE_EXISTING);
            }
        }
        
        
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
