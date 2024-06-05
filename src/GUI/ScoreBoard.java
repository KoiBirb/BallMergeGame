package GUI;
import java.awt.*;
import java.awt.FontMetrics;
import Main.GamePanel;

public class ScoreBoard extends FontMetrics{

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    int score = 0;
    String scoreDisplay = String.valueOf(score);
   
    public ScoreBoard() {
        super(new Font("Arial", Font.BOLD, 40));
        r = new Rectangle(25, 200, 300,400);
    }

    public void draw() {
        GamePanel.gc.setColor(Color.white);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
        GamePanel.gc.drawOval(100, 40, 150, 150);
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillOval(100, 40, 150, 150);
        GamePanel.gc.setFont (font);
        GamePanel.gc.drawString(scoreDisplay, 50 - (stringWidth(scoreDisplay))/2, 100);


    }

    public void update() {

    }
}

