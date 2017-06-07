package hello.world.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bloisi
 */
public class MapLoader {
    
    private Map map;
    
    public MapLoader() {
        map = null;
    }
    
    public Map loadMap (String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        }
        catch (IOException e) {
            System.err.println("Unable to load the map");
            return null;
        }
        System.out.println("Map " + filename + " loaded.");
        map = new Map(img);
        return map;
    }
    
    public Map getMap() {
        return map;
    }    
}




