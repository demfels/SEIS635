/*
 * @author daniel arnott
 */

package mediamaster;
import java.io.File;

/**
 *
 * @author daniel
 */
public class MediaFile {
    private final String type;
    private final String name;
    private final File file;
    public MediaFile(String argType, String argName, File argFile){
        type=argType;
        name=argName;
        file=argFile;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public File getFile(){
        return file;
    }
}
