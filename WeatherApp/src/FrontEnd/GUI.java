/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.*;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author kris
 */
public class GUI {

    Database db = new WeatherHistory();
    JFrame frame = new JFrame();
    
    JLabel labelFrame;
    JLabel labelURL;

    JPanel buttonPanel = new JPanel();
    JLabel labelButtonPanel;
    JPanel displayPanel = new JPanel();
    JLabel labelDisplayPanel;
    DrawingPanel gfxPanel = new DrawingPanel();


    JButton loadButton;
    JButton displayButton;
    JButton clearButton;
    JButton startStopButton;
    
    JTextField dateField;

    JTextArea textArea;

    JScrollPane scrollPane;
    Border border;
    
    String dateSearch;
    int x = 100;
    int y = 70;
    Image image;
    
    Timer timer;
    boolean animate;
    boolean right = true;
    boolean down = true; 

    public void BuildGUI() {

        // text for GUI
        //
        labelButtonPanel = new JLabel("Controls");
        labelDisplayPanel = new JLabel("Display Area");
        loadButton = new JButton("Load Observations");
        displayButton = new JButton("Display Observations");
        clearButton = new JButton("Clear Observations");
        startStopButton = new JButton ("Start / Stop");
        labelFrame = new JLabel("WeatherApp");
        labelURL = new JLabel("http://rengland.spinetail.cdu.edu.au/observations/");
        dateField = new JTextField("1/01/2015", 10);

        // border
        //
        border = BorderFactory.createLineBorder(Color.BLACK);

        // Label for Frame
        //
        labelFrame.setBorder(border);
        labelFrame.setPreferredSize(new Dimension(150, 50));
        labelFrame.setHorizontalAlignment(JLabel.CENTER);
        labelFrame.setVerticalAlignment(JLabel.TOP);

        

        // Layout for frame
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(labelFrame, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.LINE_START);
        frame.add(displayPanel, BorderLayout.LINE_END);
        frame.add(gfxPanel, BorderLayout.CENTER);
        frame.add(labelURL, BorderLayout.PAGE_END);
        
        
        // layout for gfxPanel
        gfxPanel.setSize(600, 600);
        //frame.getContentPane().setSize(600, 600);
       // frame.add(gfxPanel);
        //frame.getContentPane().add(gfxPanel);
      
        
        // layout for display panel
        displayPanel.setSize(100, 100);
        
        // Label for button panel
        //
        labelButtonPanel.setPreferredSize(new Dimension(15, 15));
        labelButtonPanel.setHorizontalAlignment(JLabel.CENTER);
        labelButtonPanel.setVerticalAlignment(JLabel.TOP);
        
        //scrollPane and textArea
        textArea = new JTextArea(20, 20);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(labelDisplayPanel, BoxLayout.X_AXIS);
        displayPanel.add(scrollPane);
       
        

        // Layout for button panel
        //
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setBorder(border);
        buttonPanel.add(labelButtonPanel);
        buttonPanel.add(loadButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(dateField);
        buttonPanel.add(startStopButton);
        buttonPanel.setSize(300, 200);

         
        // Align Buttons
        //
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateField.setAlignmentX(Component.CENTER_ALIGNMENT);
        startStopButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Event Listeners
        //
        loadButton.addMouseListener(new LoadListener());
        displayButton.addMouseListener(new DisplayListener());
        clearButton.addMouseListener(new ClearListener());
        dateField.addActionListener(new DateListener());
        startStopButton.addMouseListener(new StartStopListener());

        

        // display the frame
        //
        frame.setSize(900, 900);
        //frame.pack();
        frame.setVisible(true);
       
      timer = new Timer (10, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        
            System.out.println(animate);
        
            if (!animate) {}
            else {
          if (x <= 400 && right) {
              //System.out.println(x + " " + right);
          x++;
          } 
          if (x >= 400 && right) {
              right = false;
          } 
          if (x >= 0 && right==false) {
              x--;
          }
          if (x <= 0 && right==false) {
              right = true;
          }
          if (y <= 400 && down) {
              System.out.println(x);
          y++;
          } 
          if (y >= 400 && down) {
              down = false;
          } 
          if (y >= 0 && down==false) {
              y--;
          }
          if (y <= 0 && down==false) {
              down = true;
          }
          gfxPanel.repaint();
          
       
    }
            
          }
      });
        
        // testing animation
    }
        public void drawAnimation() {
        
        boolean right = true;
        boolean down = true;
            System.out.println(animate);
        
            while (animate) {
          if (x <= 400 && right) {
              //System.out.println(x + " " + right);
          x++;
          } 
          if (x >= 400 && right) {
              right = false;
          } 
          if (x >= 0 && right==false) {
              x--;
          }
          if (x <= 0 && right==false) {
              right = true;
          }
          if (y <= 400 && down) {
              System.out.println(x);
          y++;
          } 
          if (y >= 400 && down) {
              down = false;
          } 
          if (y >= 0 && down==false) {
              y--;
          }
          if (y <= 0 && down==false) {
              down = true;
          }
          gfxPanel.repaint();
          try {
             Thread.sleep(10);
          } catch(Exception ex) {
              ex.printStackTrace();
            
          }
       
    }
        
          //gfxPanel.repaint();
}

   
    public class DrawingPanel extends JPanel{
        public void paintComponent(Graphics page){
            Graphics2D pencil = (Graphics2D) page;
           
            pencil.setColor(Color.BLUE);
            pencil.fillRect(0, 0, 500, 500);
            
            pencil.setStroke(new BasicStroke(10));
            pencil.setColor(Color.ORANGE);
            
          
            
                 Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 100, 100);
                 pencil.fill(circle);
            
            
        }
    }
     private class StartStopListener implements MouseListener {

        public StartStopListener() {
            
          
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           
        if (!animate) {
            animate = true;
            timer.start();
        } else {
            animate = false;
            timer.stop();
        }  
                
        
            }
            
        

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
     
    private class DateListener implements ActionListener {
        
        public DateListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            dateSearch = dateField.getText();
            System.out.println(dateSearch);
            
            String dateResult = db.checkWeatherByDate(dateSearch);
           // System.out.println(dateResult);
           // dateResult = "clear";
           // System.out.println("dateResult" + dateResult);
            
            textArea.setText(dateResult);
            
           
        }
    }

    private class LoadListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea.setText("Loading.....");
            db = new WeatherHistory();
            db.loadObservationsFromHTMLFile();
            textArea.append("Done");

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

    private class DisplayListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea.setText(null);
            textArea.append(db.getObservations());
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

    private class ClearListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            textArea.setText(null);
            db = new WeatherHistory();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

    }
}
