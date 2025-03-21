package com.drawingeditor.model;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    @Override
    public void drawBorder(Graphics2D g) {
        g.setColor(Color.RED);  // Border color when selected
        g.setStroke(new BasicStroke(3));  // Border thickness
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);  // Draw border
    }
    @Override
    public boolean contains(Point point) {
        int dx = point.x - x;
        int dy = point.y - y;
        return dx * dx + dy * dy <= radius * radius;
    }
}
