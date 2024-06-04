package Balls;

import Main.GamePanel;
import hsa2.GraphicsConsole;
import java.awt.image.BufferedImage;

public class SuperBall {
    public BufferedImage image;
    public int x, y, width, height;
    public boolean isDropped;

    public SuperBall( int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDropped = false;
    }

    public void update() {
        if (GamePanel.gc.getMouseButton(0) || GamePanel.gc.getMouseButton(2))
            isDropped = true;

        if (isDropped){
            // gravity
            y += width/2;

            if (y + height > 800){
                y = 800 - height;
            }
        } else {
            x = GamePanel.gc.getMouseX() - width/2;

            if (x < 0)
                x = 0;
            else if (x + width > 600)
                x = 600 - width;
        }
    }

    public void draw(GraphicsConsole gc) {
        gc.drawImage(image, x, y, width, height);
    }
}
