package com.drawingeditor.model;

import com.drawingeditor.Util;

import java.awt.*;

public abstract class Shape {
    protected int x, y;
    protected Color color;


    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Util.getRandomColor();  // Assign a random color when the shape is created

    }

    public abstract void draw(Graphics2D g);

    public abstract boolean contains(Point point);
    public abstract void drawBorder(Graphics2D g);

    public void move(Point point) {
        this.x = point.x;
        this.y = point.y;
    }
    public Color getColor(){
        return this.color;
    }
}
