package Main;

import Ballhandlers.Collisions;
import Ballhandlers.MergerHandler;
import Ballhandlers.Spawner;
import Balls.*;
import GUI.ScoreBoard;
import GUI.TitleScreen;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class GamePanel {

    public static GraphicsConsole gc;
    private final Spawner spawner;
    private final Bucket bucket;
    private final ScoreBoard sb;
    private final MergerHandler mh;
    public static ArrayList<SuperBall> fruits;
    private final MusicHandler sound;
    BufferedImage image;
    Rectangle menu, end;
    Color buttonBackground = new Color(248, 229, 187, 98);
    Color buttonOutline = new Color (255, 240,201);

    /**
     * Constructor
     * Initializes default settings
     */
    public GamePanel() {

        gc = new GraphicsConsole(1200, 650);
        spawner = new Spawner();
        bucket = new Bucket();
        sb = new ScoreBoard();
        mh = new MergerHandler();
        fruits = new ArrayList<>();
        sound = TitleScreen.mh;

        menu = new Rectangle(875, 275, 301, 63);
        end = new Rectangle(875, 415, 301, 63);

        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676"));
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/GameScreen.jpg")));
        } catch (Exception ignored) {}
        gc.clear();
    }

    /**
     * Starts the game
     */
    public void start() {
       while (Main.gameState == 1) {
           update();
           draw();
           gc.sleep(5);
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
        sound.update();
        spawner.update();
        mh.merge();

        // avoid current modification exception
        for(int i = 0; i < fruits.size(); i++) {
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

            // avoid current modification exception
            for (int i = 0; i < fruits.size(); i++) {
                fruits.get(i).draw();
            }
        }
    }
}
