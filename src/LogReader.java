package hello.world.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.awt.geom.Point2D;

import java.util.*;

public class LogReader {
    
    private Path file;
    private Vector<Point2D> points; 
    
    public LogReader(String filename) {
        file = Paths.get(filename);
        points = new Vector<Point2D>();
    }
    
    public boolean read() {
        int skip_cnt = 0;
        LineParser parser = new LineParser();
        try (InputStream in = Files.newInputStream(file);
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                if(!parser.parseZone(line, "32North")) {
                    continue;
                }
                
                if(skip_cnt == 10) {
                    double p_x = parser.getPx();
                    double p_y = parser.getPy();
                                
                    Point2D point = new Point2D.Double(p_x, p_y);
                    points.add(point);
                    skip_cnt = 0;
                }
                skip_cnt++;
            }
        }
        catch (IOException x) {
            System.err.println(x);
            return false;
        }
        return true;
    }
    
    public Vector<Point2D> getPoints() {
        return points;
    }
}
