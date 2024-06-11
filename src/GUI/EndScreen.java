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
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class EndScreen {

    private final Rectangle button;
    private BufferedImage image;
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    private static final MusicHandler mh = new MusicHandler();


    /**
     * Constructor
     */
    public EndScreen() {
        setUp();

        button = new Rectangle(454, 480, 301, 63); //button to get into the game

        try { //import image end screen
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/EndScreen.jpg")));
        } catch (Exception e) {
            System.out.println("Image failed to Load");
        }
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
        gc.setTitle("YOU LOSE");
        gc.setBackgroundColor(Color.decode("#eab676"));
    }


    /**
     * Updates sound. If the play again button is clicked, changes game state
     */
    private void update() {
        mh.update();
        if (button.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0)
            Main.gameState = 1;
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
            gc.sleep(Main.SLEEPTIME);
        }
    }
}

