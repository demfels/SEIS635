/*
 * @author daniel arnott
 */

package mediamaster;

import java.io.File;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author daniel
 */
public class MediaCollection {
    private ArrayList<MediaFile> arrayAudioList=new ArrayList<MediaFile>();
    private ArrayList<MediaFile> arrayImageList=new ArrayList<MediaFile>();
    private ArrayList<MediaFile> arrayVideoList=new ArrayList<MediaFile>();
    public void setAudioList(ArrayList<MediaFile> argList){
        arrayAudioList=argList;
    }
    public void setImageList(ArrayList<MediaFile> argList){
        arrayImageList=argList;
    }
    public void setVideoList(ArrayList<MediaFile> argList){
        arrayVideoList=argList;
    }
    public void addAudioFile(MediaFile argFile){
        arrayAudioList.add(argFile);
    }
    public void addImageFile(MediaFile argFile){
        arrayImageList.add(argFile);
    }
    public void addVideoFile(MediaFile argFile){
        arrayVideoList.add(argFile);
    }
    public ArrayList getAudioList(){
        return arrayAudioList;
    }
    public ArrayList getImageList(){
        return arrayImageList;
    }    
    public ArrayList getVideoList(){
        return arrayVideoList;
    }
}
