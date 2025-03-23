package com.example.demo.services;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RouteService {

    public Image generateRouteImage(String from, String to) {
        int width = 400;
        int height = 200;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);
        g.drawString("Route: " + from + " → " + to, 20, 100);
        g.dispose();

        WritableImage fxImage = new WritableImage(width, height);
        return SwingFXUtils.toFXImage(bufferedImage, fxImage);
    }
}
