/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediamaster;
import java.io.*;
import java.util.*;

/**
 *
 * @author daniel
 */
public class FileSearch {
String directory;
String fileType;
ArrayList<File> returnList=new ArrayList<File>();
    public ArrayList<File> listAudio(String argPath){
        directory=argPath;
        File dir = new File(directory);
        File[] matchingFiles = dir.listFiles();
        for (File fil : matchingFiles)
        {   
            String filePath = fil.getPath();
            if(filePath.contains(".mp3")){
                System.out.println("[DEBUG] "+fil.getPath());
                boolean add;
                add = returnList.add(fil);
            }
        }
        return returnList;
    }
        public ArrayList<File> listImage(String argPath){
        directory=argPath;
        File dir = new File(directory);
        File[] matchingFiles = dir.listFiles();
        for (File fil : matchingFiles)
        {   
            String filePath = fil.getPath();
            if(filePath.contains(".bmp")){
                System.out.println("[DEBUG] "+fil.getPath());
                boolean add;
                add = returnList.add(fil);
            }
        }
        return returnList;
    }
        public ArrayList<File> listVideo(String argPath){
        directory=argPath;
        File dir = new File(directory);
        File[] matchingFiles = dir.listFiles();
        for (File fil : matchingFiles)
        {   
            String filePath = fil.getPath();
            if(filePath.contains(".wmv")){
                System.out.println("[DEBUG] "+fil.getPath());
                boolean add;
                add = returnList.add(fil);
            }
        }
        return returnList;
    }
}
