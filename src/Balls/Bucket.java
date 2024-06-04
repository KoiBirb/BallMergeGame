package Balls;

import Main.GamePanel;

import java.awt.*;

public class Bucket {

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);

    public Bucket() {
        r = new Rectangle(350, 200, 500, 450);
    }

    public void update(){

    }

    public void draw() {
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
    }
}
