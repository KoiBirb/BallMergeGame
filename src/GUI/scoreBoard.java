package GUI;
import hsa2.GraphicsConsole;
import java.awt.*;

import Main.GamePanel;
import java.text.ParseException;

public class scoreBoard {

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    int score = 0;
    String scoreDisplay = String.valueOf(score);
   
    public scoreBoard() {
        r = new Rectangle(100, 200, 100,200);

    }

    public void draw() {
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
        GamePanel.gc.drawOval(100, 100, 70, 70);
        GamePanel.gc.drawString(score, 130, 145);
    }

    public void update() {

    }

}

