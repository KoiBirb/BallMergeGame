package Main;

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

    // initialize classes
    public static GraphicsConsole gc;
    private final Spawner spawner;
    private final Bucket bucket;
    private final ScoreBoard sb;
    private final MergerHandler mh;
    public static ArrayList<SuperBall> fruits;
    private final MusicHandler sound;
    BufferedImage image;
    Rectangle menu, end;

    // set default settings
    public GamePanel() {

        gc = new GraphicsConsole(1200, 650);
        spawner = new Spawner();
        bucket = new Bucket();
        sb = new ScoreBoard();
        mh = new MergerHandler();
        fruits = new ArrayList<>();
        sound = TitleScreen.mh;

        menu = new Rectangle(454, 425, 301, 63);
        end = new Rectangle(600, 425, 301, 63);

        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676"));
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/GameScreen.jpg")));
        } catch (Exception ignored) {}
        sound.playMerge = true;
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
            Main.gameState = 0;
        }

        if (end.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0) {
            Main.gameState = 2;
        }

        spawner.update();
        bucket.update();
        for (SuperBall ball : fruits) {
            ball.update();
        }
        mh.merge();
        sound.update();
    }

    /**
     * Draws the game
     */
    private void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();
            gc.drawImage(image,0,0);
            gc.drawRect(menu.x, menu.y, menu.width, menu.height);
            gc.drawRect(end.x, end.y, end.width, end.height);
            sb.draw();
            bucket.draw();

            spawner.draw();
            for (SuperBall ball : fruits) {
                ball.draw(gc);
            }
        }
    }
}
