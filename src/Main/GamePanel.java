package Main;

import Ballhandlers.MergerHandler;
import Ballhandlers.Spawner;
import Balls.*;
import GUI.ScoreBoard;
import hsa2.GraphicsConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class GamePanel {

    private final int SLEEPTIME = 5;

    // initialize classes
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    private final Spawner spawner = new Spawner();
    private final Bucket bucket = new Bucket();
    private final ScoreBoard sb = new ScoreBoard();
    private final MergerHandler mh = new MergerHandler();
    public static ArrayList<SuperBall> fruits = new ArrayList<>();
    BufferedImage image;

    // set default settings
    public GamePanel() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("Ball Drop");
        gc.setBackgroundColor(Color.decode("#eab676"));
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/GameScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        gc.clear();
    }

    /**
     * Starts the game
     */
    public void start() {
       while (true) {
           update();
           draw();
           gc.sleep(SLEEPTIME);
       }
    }

    /**
     * Updates the game
     */
    private void update() {
        spawner.update();
        sb.update();
        bucket.update();
        for (SuperBall ball : fruits) {
            ball.update();
        }
        mh.merge();
    }

    /**
     * Draws the game
     */
    private void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();
            gc.drawImage(image,0,0);

            bucket.draw();
            sb.draw();
            spawner.draw();
            for (SuperBall ball : fruits) {
                ball.draw(gc);
            }
        }
    }
}
