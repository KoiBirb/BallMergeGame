package Main;

import Ballhandlers.Spawner;
import Balls.*;
import hsa2.GraphicsConsole;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel {

    private final int SLEEPTIME = 5;

    // initialize classes
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    private final Spawner spawner = new Spawner();
    private final Bucket bucket = new Bucket();
    public static ArrayList<SuperBall> fruits = new ArrayList<>();

    // set default settings
    public GamePanel() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("Ball Drop");
        gc.setBackgroundColor(Color.decode("#eab676"));
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
        bucket.update();
        for (SuperBall ball : fruits) {
            ball.update();
        }
    }

    /**
     * Draws the game
     */
    private void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();

            bucket.draw();
            spawner.draw();
            for (SuperBall ball : fruits) {
                ball.draw(gc);
            }
        }
    }
}
