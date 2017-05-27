/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.*;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import javax.swing.JTextField;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

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

    JButton loadButton;
    JButton displayButton;
    JButton clearButton;

    JTextArea textArea;

    JScrollPane scrollPane;
    Border border;

    public void BuildGUI() {

        // text for GUI
        //
        labelButtonPanel = new JLabel("Controls");
        labelDisplayPanel = new JLabel("Display Area");
        loadButton = new JButton("Load Observations");
        displayButton = new JButton("Display Observations");
        clearButton = new JButton("Clear Observations");
        labelFrame = new JLabel("WeatherApp");
        labelURL = new JLabel("http://rengland.spinetail.cdu.edu.au/observations/");

        // border
        //
        border = BorderFactory.createLineBorder(Color.BLACK);

        // Label for Frame
        //
        labelFrame.setBorder(border);
        labelFrame.setPreferredSize(new Dimension(150, 50));
        labelFrame.setHorizontalAlignment(JLabel.CENTER);
        labelFrame.setVerticalAlignment(JLabel.TOP);

        // Label for button panel
        //
        labelButtonPanel.setPreferredSize(new Dimension(15, 15));
        labelButtonPanel.setHorizontalAlignment(JLabel.CENTER);
        labelButtonPanel.setVerticalAlignment(JLabel.TOP);

        // Layout for frame
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(labelFrame, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.LINE_START);
        frame.add(displayPanel, BorderLayout.CENTER);
        frame.add(labelURL, BorderLayout.PAGE_END);

        // Layout for button panel
        //
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setBorder(border);
        buttonPanel.add(labelButtonPanel);
        buttonPanel.add(loadButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);

        // Align Buttons
        //
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Event Listeners
        //
        loadButton.addMouseListener(new LoadListener());
        displayButton.addMouseListener(new DisplayListener());
        clearButton.addMouseListener(new ClearListener());

        //scrollPane and textArea
        textArea = new JTextArea(20, 20);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(labelDisplayPanel);
        displayPanel.add(scrollPane);

        // display the frame
        //
        frame.pack();
        frame.setVisible(true);
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
