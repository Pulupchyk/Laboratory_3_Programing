package com.fpm.project;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        int n = 1;
        int a = 10 * (n + 1);
        double angle = (a * Math.PI) / 180;
        try (BufferedReader br = new BufferedReader(new FileReader("DS1.txt"))) {
            String str;
            BufferedImage bufferedImage = new BufferedImage(960, 960, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.setPaint(Color.blue);
            while ((str = br.readLine()) != null) {
                String s[] = str.split(" ");
                int x = Integer.parseInt(s[0]) - 480;
                int y = Integer.parseInt(s[1]) - 480;
                double px = 480 + ((x * Math.cos(angle)) - (y * Math.sin(angle)));
                double py = 480 + ((x * Math.sin(angle)) + (y * Math.cos(angle)));
                g.drawLine((int)px, (int)py, (int)px, (int)py);
            }
            ImageIO.write(bufferedImage, "png", new File("result_b.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}