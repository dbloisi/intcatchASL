/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.world.app;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author bloisi
 */
public class HelloWorldApp {

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hello World INTCATCH");
        System.out.println("--------------------");
        System.out.println();
        
        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        
        MapLoader mapLoader = new MapLoader();
        //Map map = mapLoader.loadMap("data/lake-big.png");
        //Map map = mapLoader.loadMap("data/atlantide.png");
        Map map = mapLoader.loadMap("data/atlantide-detail.png");
        if(map == null) {
            return;
        }
                
        createAndShowGUI(map);
        
        
        

        
        System.out.println("Hello World!");
        return;
    }
    
    private static void createAndShowGUI(Map map) {
        Framework framework = new Framework(map,"data/log.txt");
        framework.run();
    }
    
    
}
