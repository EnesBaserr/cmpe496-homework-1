package com.drawingeditor;

import com.drawingeditor.button.ToolbarButton;
import com.drawingeditor.model.Circle;
import com.drawingeditor.model.Line;
import com.drawingeditor.model.Square;
import com.drawingeditor.panel.DrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawingEditor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);


        // Create the erase button and set it initially to be disabled
        JButton eraseButton = new JButton("Erase");

        // Create the drawing panel, passing the erase button to the constructor
        DrawingPanel drawingPanel = new DrawingPanel(eraseButton);
        eraseButton.setEnabled(false);  // Initially disable the erase button
        eraseButton.addActionListener((ActionEvent e) -> {
            // Erase the selected shape when the erase button is clicked
            drawingPanel.eraseSelectedShape();
            eraseButton.setEnabled(false);  // Disable the erase button after erasing
        });

        frame.add(drawingPanel, BorderLayout.CENTER);

        // Create buttons for interaction

        // Create the toolbar
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create the toolbar buttons using the ToolbarButton class
        ToolbarButton addCircleButton = new ToolbarButton("Add Circle",  (ActionEvent e) -> {
            int x = (int) (Math.random() * drawingPanel.getWidth());
            int y = (int) (Math.random() * drawingPanel.getHeight());
            drawingPanel.addShape(new Circle(x, y, 50));  // Add circle at random position
        });

        ToolbarButton addSquareButton = new ToolbarButton("Add Square",  (ActionEvent e) -> {
            int x = (int) (Math.random() * drawingPanel.getWidth());
            int y = (int) (Math.random() * drawingPanel.getHeight());
            drawingPanel.addShape(new Square(x, y, 50));  // Add square at random position
        });

        ToolbarButton addLineButton = new ToolbarButton("Add Line",  (ActionEvent e) -> {
            int x1 = (int) (Math.random() * drawingPanel.getWidth());
            int y1 = (int) (Math.random() * drawingPanel.getHeight());
            int x2 = Math.min(x1 + 100, drawingPanel.getWidth());
            int y2 = Math.min(y1 + 100, drawingPanel.getHeight());
            drawingPanel.addShape(new Line(x1, y1, x2, y2));  // Add line at random position
        });

        // Add buttons to toolbar
        toolbar.add(addCircleButton.getButton());
        toolbar.add(addSquareButton.getButton());
        toolbar.add(addLineButton.getButton());
        toolbar.add(eraseButton);

        // Add toolbar to the frame
        frame.add(toolbar, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
