package com.drawingeditor.model;

import java.awt.*;

public class Square extends Shape {
    private int size;

    public Square(int x, int y, int size) {
        super(x, y);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        g.fillRect(x - size / 2, y - size / 2, size, size);
    }
    @Override
    public void drawBorder(Graphics2D g) {
        g.setColor(Color.RED);  // Border color when selected
        g.setStroke(new BasicStroke(3));  // Border thickness
        g.drawRect(x - size / 2, y - size / 2, size, size);  // Draw border
    }
    @Override
    public boolean contains(Point point) {
        return point.x >= x - size / 2 && point.x <= x + size / 2 &&
                point.y >= y - size / 2 && point.y <= y + size / 2;
    }
}
