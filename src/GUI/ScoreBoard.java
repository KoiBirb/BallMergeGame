package GUI;
import java.awt.*;
import java.awt.FontMetrics;
import Main.GamePanel;

public class ScoreBoard{

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    int score = 0;
    String scoreDisplay = String.valueOf(score);
    Font font = new Font("Arial", Font.BOLD, 40);
    FontMetrics fm = GamePanel.gc.getFontMetrics(font);
   
    public ScoreBoard() {
        super();
        r = new Rectangle(25, 200, 300,400);
    }

    public void draw() {
        GamePanel.gc.setColor(Color.white);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
        GamePanel.gc.drawOval(100, 40, 150, 150);
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillOval(100, 40, 150, 150);
        GamePanel.gc.setFont (font);
        GamePanel.gc.drawString(scoreDisplay, 50 - (fm.stringWidth(scoreDisplay))/2, 100);


    }

    public void update() {

    }
}

