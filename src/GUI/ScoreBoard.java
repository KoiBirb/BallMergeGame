package GUI;
import java.awt.*;
import java.awt.FontMetrics;
import Main.GamePanel;

public class ScoreBoard{

    Rectangle r;
    //Color transparentWhite = new Color(255, 255, 255, 40);
    Color creme = new Color(255, 240,201);
    Color transparentC = new Color(248, 229, 187, 95);
    int score = 10000;
    String scoreDisplay = String.valueOf(score);
    Font font = new Font("Arial", Font.BOLD, 40);
    FontMetrics fm = GamePanel.gc.getFontMetrics(font);
   
    public ScoreBoard() {
        super();
        r = new Rectangle(25, 200, 300,400);
    }

    public void draw() {
        GamePanel.gc.setColor(transparentC);
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height);
        GamePanel.gc.setStroke(5);
        GamePanel.gc.setColor(creme);
        GamePanel.gc.drawRect(r.x, r.y, r.width, r.height);
        GamePanel.gc.setColor(creme);
        GamePanel.gc.drawOval(100, 40, 150, 150);
        GamePanel.gc.setColor(transparentC);
        GamePanel.gc.fillOval(100, 40, 150, 150);
        GamePanel.gc.setFont (font);
        GamePanel.gc.drawString(scoreDisplay, 175 - (fm.stringWidth(scoreDisplay))/2, 130);
        GamePanel.gc.setColor(creme);
        GamePanel.gc.drawString("TOP SCORES", 55, 240);
        GamePanel.gc.fillRect(60, 260,230, 40);

    }

    public void update() {

    }
}

