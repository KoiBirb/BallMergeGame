package GUI;
import java.awt.*;
import java.awt.FontMetrics;
import Main.GamePanel;

public class ScoreBoard{

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    public static int score = 0;
    int[] topScores = new int[7];
    Font font = new Font("Arial", Font.BOLD, 40);
    FontMetrics fm = GamePanel.gc.getFontMetrics(font);
   
    public ScoreBoard() {
        super();
        r = new Rectangle(25, 200, 300,400);
    }

    public void draw() {
        GamePanel.gc.setColor(new Color(248, 229, 187, 95));
        GamePanel.gc.fillRoundRect(r.x, r.y, r.width, r.height,30,30);
        GamePanel.gc.setStroke(5);
        GamePanel.gc.setColor(new Color(255, 240,201));
        GamePanel.gc.drawRoundRect(r.x, r.y, r.width, r.height,30,30);
        GamePanel.gc.setColor(Color.white);
        GamePanel.gc.drawOval(100, 40, 150, 150);
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillOval(100, 40, 150, 150);
        GamePanel.gc.setColor(Color.white);
        GamePanel.gc.setFont (font);
        GamePanel.gc.drawString(String.valueOf(score), 175 - (fm.stringWidth(String.valueOf(score)))/2, 130);
        GamePanel.gc.drawString("TOP SCORES", 55, 240);
        GamePanel.gc.setColor(new Color(250, 194, 61, 255));
        GamePanel.gc.fillRoundRect(60, 250,230, 40,30,30);
        GamePanel.gc.setColor(new Color(105, 138, 250));
        GamePanel.gc.fillRoundRect(60, 300,230, 40,30,30);
        GamePanel.gc.setColor(new Color(211, 121, 47));
        GamePanel.gc.fillRoundRect(60, 350,230, 40,30,30);
        GamePanel.gc.setColor(new Color(174, 174, 174));
        GamePanel.gc.fillRoundRect(60, 400,230, 40,30,30);
        GamePanel.gc.fillRoundRect(60, 450,230, 40,30,30);
        GamePanel.gc.fillRoundRect(60, 500,230, 40,30,30);
        GamePanel.gc.fillRoundRect(60, 550,230, 40,30,30);

    }

    public void update() {

    }
}

