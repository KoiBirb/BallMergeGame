package GUI;
import java.awt.*;
import java.awt.FontMetrics;
import Main.GamePanel;

public class ScoreBoard {

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    int score = 0;
    String scoreDisplay = String.valueOf(score);
    Font font = new Font("Arial", Font.PLAIN, 12);
    FontMetrics metrics = g.getFontMetrics(font);
   
    public ScoreBoard() {
        r = new Rectangle(100, 200, 100,200);
    }

    public void draw() {
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
        GamePanel.gc.drawOval(100, 100, 70, 70);
        GamePanel.gc.drawString(scoreDisplay, 130, 145);

        /*
         String str = "Hello, World!";

            // Get the width of the string
            int width = metrics.stringWidth(str);

            System.out.println("The width of the string is: " + width + " pixels.");
         */

    }

    public void update() {

    }
}

