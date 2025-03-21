package com.drawingeditor;

import java.awt.*;
import java.util.Random;

public class Util {
    private static final Random random = new Random();

    // Generate a random color
    public static Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}