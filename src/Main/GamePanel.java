package Main;

import Ballhandlers.Collisions;
import Ballhandlers.MergerHandler;
import Ballhandlers.Spawner;
import Balls.*;
import GUI.Bucket;
import GUI.ScoreBoard;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class GamePanel {

    public final static GraphicsConsole gc = new GraphicsConsole(1200, 650);
    private final Spawner spawner;
    private final Bucket bucket;
    private final ScoreBoard sb;
    private final MergerHandler mergeH;
    private final MusicHandler mh;
    public static ArrayList<SuperBall> fruits;
    private BufferedImage image;
    private final Rectangle menu, end;
    private final Color buttonBackground = new Color(248, 229, 187, 98);
    private final Color buttonOutline = new Color (255, 240,201);

    /**
     * Constructor
     */
    public GamePanel() {
        setUp();

        spawner = new Spawner();
        bucket = new Bucket();
        sb = new ScoreBoard();
        mergeH = new MergerHandler();
        fruits = new ArrayList<>();
        mh = Main.mh;

        menu = new Rectangle(875, 275, 301, 63);
        end = new Rectangle(875, 415, 301, 63);

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/GameScreen.jpg")));
        } catch (Exception ignored) {}
        gc.clear();
    }

    /**
     * Sets graphics console settings
     */
    private void setUp(){
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676"));
    }

    /**
     * Starts the game
     */
    public void start() {
       while (Main.gameState == 1) {
           update();
           draw();
           gc.sleep(Main.SLEEPTIME);
       }
    }

    /**
     * Updates the game
     */
    private void update() {
        // Change Game state
        if (menu.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0) {
            fruits.clear();
            Main.gameState = 0;
        }

        if (end.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0) {
            fruits.clear();
            Main.gameState = 2;
        }

        // update objects
        mh.update();
        spawner.update();
        mergeH.merge();

        for(int i = 0; i < fruits.size(); i++) { // avoid current modification exception
            fruits.get(i).update();
            Collisions.checkLost(fruits.get(i));
        }
    }

    /**
     * Draws the game
     */
    private void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();

            gc.drawImage(image,0,0);// draw background

            sb.draw();
            bucket.draw();
            spawner.draw();

            // Draw buttons
            gc.setColor(buttonBackground);
            gc.fillRoundRect(menu.x, menu.y, menu.width, menu.height, 30,30);
            gc.fillRoundRect(end.x, end.y, end.width, end.height, 30,30);

            gc.setColor(buttonOutline);
            gc.drawRoundRect(menu.x, menu.y, menu.width, menu.height, 30,30);
            gc.drawRoundRect(end.x, end.y, end.width, end.height, 30,30);

            gc.setColor(Color.WHITE);
            gc.drawString("MENU", menu.x+90, menu.y+45);
            gc.drawString("END GAME", end.x+50, end.y+45);

            for (int i = 0; i < fruits.size(); i++) {  // avoid current modification exception
                fruits.get(i).draw();
            }
        }
    }
}
