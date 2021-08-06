package dev.luisalberto.kochsnowflake;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class KochSnowflake extends JPanel {

    private double startX;
    private double startY;
    private double angle;

    public KochSnowflake() {
        startX = (this.getWidth() - 500d) / 2;
        startY = (this.getHeight() - 300d) / 2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        startX = (this.getWidth() - 500d) / 2;
        startY = (this.getHeight() - 300d) / 2;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int level = 5;
        int size = (int) (500 / (Math.pow(3, level)));

        kochSnowflake(level, size, g2);
        angle += 120;
        kochSnowflake(level, size, g2);
        angle += 120;
        kochSnowflake(level, size, g2);
    }

    public void kochSnowflake(int level, int size, Graphics2D g2) {

        if (level == 0) {

            double endX = (Math.cos(Math.toRadians(angle)) * size + startX);
            double endY = (Math.sin(Math.toRadians(angle)) * size + startY);

            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            g2.drawLine((int) startX, (int) startY, (int) endX, (int) endY);

            startX = endX;
            startY = endY;

        } else {
            kochSnowflake(level - 1, size, g2);
            angle -= 60;
            kochSnowflake(level - 1, size, g2);
            angle += 120;
            kochSnowflake(level - 1, size, g2);
            angle -= 60;
            kochSnowflake(level - 1, size, g2);
        }
    }
}
