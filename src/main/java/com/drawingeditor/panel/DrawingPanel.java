package com.drawingeditor.panel;

import com.drawingeditor.model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private List<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null;
    private JButton eraseButton;

    public DrawingPanel(JButton eraseButton) {
        this.eraseButton = eraseButton;

        // Mouse listener to detect clicks
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedShape = null;
                for (Shape shape : shapes) {
                    if (shape.contains(e.getPoint())) {
                        selectedShape = shape;
                        eraseButton.setEnabled(true);  // Enable erase button when a shape is selected
                        break;
                    }
                    else{
                        eraseButton.setEnabled(false);  // Disable erase button when no shape is selected
                    }
                }
                repaint();
            }
        });

        // Mouse motion listener for dragging
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedShape != null) {
                    selectedShape.move(e.getPoint());
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the paper background
        setBackground(new Color(255, 248, 220));  // Paper-like color

        Graphics2D g2d = (Graphics2D) g;

        // Add a subtle grid effect
        drawGrid(g2d);

        // Draw all shapes
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }

        // If a shape is selected, draw a border around it
        if (selectedShape != null) {
            g2d.setColor(Color.RED);  // Set border color
            g2d.setStroke(new BasicStroke(3));  // Set border thickness
            selectedShape.drawBorder(g2d);  // Call the method to draw the border
        }
    }

    // Add a subtle grid effect to simulate a paper-like grid
    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);  // Light gray color for the grid
        for (int i = 0; i < getWidth(); i += 40) {
            g2d.drawLine(i, 0, i, getHeight());  // Vertical grid lines
        }
        for (int j = 0; j < getHeight(); j += 40) {
            g2d.drawLine(0, j, getWidth(), j);  // Horizontal grid lines
        }
    }

    // Add a shape to the list
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    // Erase the selected shape
    public void eraseSelectedShape() {
        if (selectedShape != null) {
            shapes.remove(selectedShape);
            selectedShape = null;
            eraseButton.setEnabled(false);  // Disable erase button after erasure
            repaint();
        }
    }
}
