/**
 * EndScreen.java
 * Mariana Trillos
 * June 12, 2024
 * Draws end screen
 */

package GUI;
import Main.Main;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;
import Main.Sort;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class EndScreen {
    //variables and class initializing
    private final int SLEEPTIME = 5;
    public static Rectangle button;
    BufferedImage image;
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    public static MusicHandler mh = new MusicHandler();


    /**
     * Constructor
     */
    public EndScreen() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("YOU LOSE");
        gc.setBackgroundColor(Color.decode("#eab676")); //in case the image doesn't work

        button = new Rectangle(454, 480, 301, 63); //button to get into the game

        try { //import image end screen
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/EndScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        gc.clear();
    }

    /**
     * Updates sound. If the play again button is clicked, changes gamestate
     */
    private void update() {
        mh.update();
        if (button.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0) {
            Main.gameState = 1;
        }
    }

    /**
     * draws background
     */
    void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();
            gc.drawImage(image, 0, 0);
        }
    }

    /**
     * Runs end screen
     */
    public void start() {
        while (Main.gameState == 2) {
            update();
            draw();
            gc.sleep(SLEEPTIME);
        }
    }
}

