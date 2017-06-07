package hello.world.app;

import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Framework implements ActionListener{

    private Map map;
    private BufferedImage img;
    private String logFilename;
    
    private JFrame frame;    
    private JButton playButton, stopButton, nextButton;
    
    //actions
    //0 standby
    //1 play
    //2 stop
    //3 next
    private int actions;
    boolean next_pressed;
    
    public Framework(Map map, String logFilename) {
        this.map = map;
        this.logFilename = logFilename;
        this.img = map.getImg();
        
        //JFrame
        frame = new JFrame("INTCATCH Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
        //JButtons
        ImageIcon playButtonIcon = new ImageIcon("images/play.jpg");
        ImageIcon stopButtonIcon = new ImageIcon("images/stop.jpg");
        ImageIcon nextButtonIcon = new ImageIcon("images/next.jpg");
                
        playButton = new JButton(playButtonIcon);
        playButton.setActionCommand("play");
 
        stopButton = new JButton(stopButtonIcon);
        stopButton.setActionCommand("stop");
        
        nextButton = new JButton(nextButtonIcon);
        nextButton.setActionCommand("next");
 
        //Listen for actions on buttons 1, 2 and 3.
        playButton.addActionListener(this);
        stopButton.addActionListener(this);
        nextButton.addActionListener(this);
 
        playButton.setToolTipText("play");
        stopButton.setToolTipText("stop");
        nextButton.setToolTipText("next");

        //JPanel        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(playButton);
        panel.add(stopButton);
        panel.add(nextButton);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        
        //JLabel
        JLabel label = new JLabel(new ImageIcon(img));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
        
        actions = 0;
        next_pressed = false;
    }
    
    public void run() {
        LogReader logReader = new LogReader(logFilename);
        logReader.read();
        
        Vector<Point2D> points = logReader.getPoints();
        
        while(actions == 0) {
            //wait
            try{
                Thread.sleep(30);
            }
            catch(InterruptedException ie) {
                
            }
        }
                
        Iterator it = points.iterator();
        //System.out.println("Points:");
        while(it.hasNext()) {
            //stop
            while(actions == 2) {
                //wait
                try{
                    Thread.sleep(30);
                }
                catch(InterruptedException ie) {

                }
            }
            //next
            while(actions == 3) {
                //wait
                try{
                    Thread.sleep(30);
                }
                catch(InterruptedException ie) {

                }
                if(next_pressed) {
                    next_pressed = false;
                    break;
                }
            }
            Point2D point = (Point2D)it.next(); 
            //System.out.println(point.getX() + " " + point.getY());
            int width = img.getWidth();
            int height = img.getHeight();
            double x = ((point.getX() - map.ul_utm_easting)/
                       (map.br_utm_easting - map.ul_utm_easting)) *
                       (double)width;
            double y = ((point.getY() - map.ul_utm_northing)/
                       (map.br_utm_northing - map.ul_utm_northing)) * 
                       (double)height;
            
            System.out.println(x);
            System.out.println(y);
            
            // Create a graphics context on the buffered image
            Graphics2D g2d = img.createGraphics();
            // Draw on the buffered image
            g2d.setColor(Color.red);
            g2d.fill(new Ellipse2D.Double(x, y, 2, 2));
            g2d.dispose();
                        
            System.out.println("qua si");
            
            frame.revalidate();
            frame.repaint();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if ("play".equals(e.getActionCommand())) {
            playButton.setEnabled(false);
            stopButton.setEnabled(true);
            nextButton.setEnabled(true);
            
            actions = 1;
            
            System.out.println("play");
        }
        else if ("stop".equals(e.getActionCommand())) {
            playButton.setEnabled(true);
            stopButton.setEnabled(false);
            nextButton.setEnabled(true);
            
            actions = 2;
        }
        else if ("next".equals(e.getActionCommand())) {
            playButton.setEnabled(true);
            stopButton.setEnabled(true);
            nextButton.setEnabled(true);
            
            actions = 3;
            next_pressed = true;
        }
    }    
}

