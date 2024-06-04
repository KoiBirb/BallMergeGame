package GUI;
import java.awt.*;

import Main.GamePanel;

public class scoreBoard {

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    int score = 0;
   
    public scoreBoard() {
        r = new Rectangle(100, 200, 100,200);

    }

    public void draw() {
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
    }

    public void update() {

    }

}

