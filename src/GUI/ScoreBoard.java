package GUI;
import java.awt.*;
import java.awt.FontMetrics;
import Main.GamePanel;

public class ScoreBoard{

    Rectangle r;
    Color transparentWhite = new Color(255, 255, 255, 40);
    public static int score = 0;
    public static int[] topScores = new int[7];
    Font font = new Font("Arial", Font.BOLD, 40);
    FontMetrics fm = GamePanel.gc.getFontMetrics(font); //centers text

    /**
     * constructor
     */
    public ScoreBoard() {
        r = new Rectangle(25, 200, 300,400);
    }

    /**
     * Draws scoreboard and displays scores
     */
    public void draw() {
        //score board
        GamePanel.gc.setColor(new Color(248, 229, 187, 95));
        GamePanel.gc.fillRoundRect(r.x, r.y, r.width, r.height,30,30);
        GamePanel.gc.setStroke(5);
        GamePanel.gc.setColor(new Color(255, 240,201));
        GamePanel.gc.drawRoundRect(r.x, r.y, r.width, r.height,30,30);
        GamePanel.gc.setColor(Color.white);
        //score bubble
        GamePanel.gc.drawOval(100, 40, 150, 150);
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillOval(100, 40, 150, 150);
        GamePanel.gc.setColor(Color.white);
        GamePanel.gc.setFont (font);
        GamePanel.gc.drawString(String.valueOf(score), 175 - (fm.stringWidth(String.valueOf(score)))/2, 130);
        // more score board
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
        GamePanel.gc.setColor(Color.WHITE);
        GamePanel.gc.drawString(String.valueOf(topScores[0]), 175 - (fm.stringWidth(String.valueOf(topScores[0])))/2, 285);
        GamePanel.gc.drawString(String.valueOf(topScores[1]), 175 - (fm.stringWidth(String.valueOf(topScores[1])))/2, 335);
        GamePanel.gc.drawString(String.valueOf(topScores[2]), 175 - (fm.stringWidth(String.valueOf(topScores[2])))/2, 385);
        GamePanel.gc.drawString(String.valueOf(topScores[3]), 175 - (fm.stringWidth(String.valueOf(topScores[3])))/2, 435);
        GamePanel.gc.drawString(String.valueOf(topScores[4]), 175 - (fm.stringWidth(String.valueOf(topScores[4])))/2, 485);
        GamePanel.gc.drawString(String.valueOf(topScores[5]), 175 - (fm.stringWidth(String.valueOf(topScores[5])))/2, 535);
        GamePanel.gc.drawString(String.valueOf(topScores[6]), 175 - (fm.stringWidth(String.valueOf(topScores[6])))/2, 585);

    }

}

