package hello.world.app;

import java.awt.image.BufferedImage;


/**
 *
 * @author bloisi
 */
public class Map {
    
    private BufferedImage img;
    
    //upper left corner
    double ul_lat;
    double ul_lng;
 
    double ul_utm_easting;
    double ul_utm_northing;
    String ul_utm_zone;
    
    //bottom right corner
    double br_lat;
    double br_lng;
 
    double br_utm_easting;
    double br_utm_northing;
    String br_utm_zone;
    
    public Map(BufferedImage img) {
        this.img = img;
        
        //atlantide-detail.png
        ul_lat = 45.359526; 
        ul_lng = 11.019881;  
        ul_utm_easting = 658198.412;
        ul_utm_northing = 5024874.977;
        ul_utm_zone = "32T";
        
        br_lat = 45.358839; 
        br_lng = 11.021578; 
        br_utm_easting = 658333.238;
        br_utm_northing = 5024801.992;
        br_utm_zone = "32T";
        
        
        //atlantide.png
        /*
        ul_lat = 45.360600; 
        ul_lng = 11.019061;  
        ul_utm_easting = 658131.196;
        ul_utm_northing = 5024992.68;
        ul_utm_zone = "32T";
        
        br_lat = 45.358207; 
        br_lng = 11.024177; 
        br_utm_easting = 658538.561;
        br_utm_northing = 5024736.897;
        br_utm_zone = "32T";
        */
        
        //lake.png
        /*
        ul_lat = 45.361284;
        ul_lng = 11.019002;        
        ul_utm_easting = 658124.67;
        ul_utm_northing = 5025068.55;
               
        br_lat = 45.358201;
        br_lng = 11.024667; 
        br_utm_easting = 658576.96;
        br_utm_northing = 5024737.20;
        */
    }
    
    public double getUlLat () {
        return ul_lat;
    }
    
    public double getUlLng () {
        return ul_lng;
    }
    
    public double getUlUtmEasting () {
        return ul_utm_easting;
    }
    
    public double getUlUtmNorthing () {
        return ul_utm_northing;
    }
    
    public String getUlUtmZone () {
        return ul_utm_zone;
    }
    
    public double getBrLat () {
        return br_lat;
    }
    
    public double getBrLng () {
        return br_lng;
    }
    
    public double getBrUtmEasting () {
        return br_utm_easting;
    }
    
    public double getBrUtmNorthing () {
        return br_utm_northing;
    }
    
    public String getBrUtmZone () {
        return br_utm_zone;
    }
    
    public BufferedImage getImg() {
        return img;
    }
}




