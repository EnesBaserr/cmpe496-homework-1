package com.drawingeditor.model;

import java.awt.*;

public class Line extends Shape {
    private int x2, y2;

    public Line(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setStroke(new BasicStroke(5)); // Set the thickness for the actual line (can be adjusted)
        g.setColor(getColor());  // Use the fixed color when drawing the line
        g.drawLine(x, y, x2, y2); // Draw the actual line
    }

    @Override
    public boolean contains(Point point) {
        int buffer = 5; // Buffer distance to detect near the line
        return point.x >= Math.min(x, x2) - buffer && point.x <= Math.max(x, x2) + buffer &&
                point.y >= Math.min(y, y2) - buffer && point.y <= Math.max(y, y2) + buffer;
    }

    @Override
    public void drawBorder(Graphics2D g) {
        // First, draw the border around the line with a thicker stroke
        g.setColor(Color.RED);  // Border color when selected (you can change this)
        g.setStroke(new BasicStroke(8));  // Thicker stroke for the border
        g.drawLine(x, y, x2, y2);  // Draw the border (outline) of the line

        // Now, draw the original line on top of the border with a thinner stroke
        g.setColor(getColor());  // Use the original color for the line
        g.setStroke(new BasicStroke(5));  // Thinner stroke for the actual line
        g.drawLine(x, y, x2, y2);  // Draw the original line
    }

    @Override
    public void move(Point point) {
        // Move the starting point (x, y) and the ending point (x2, y2)
        int dx = point.x - x;
        int dy = point.y - y;
        this.x = point.x;
        this.y = point.y;
        this.x2 += dx;  // Update end point
        this.y2 += dy;  // Update end point
    }
}
