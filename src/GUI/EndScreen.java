package GUI;
import Main.Main;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class EndScreen {
    //variables and class initializing
    private final int SLEEPTIME = 5;
    public static Rectangle button, help;
    BufferedImage image, image2;
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    public static MusicHandler mh = new MusicHandler();


    // set default settings
    public EndScreen() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("YOU LOSE");
        gc.setBackgroundColor(Color.decode("#eab676")); //incase the image doesnt work
        gc.clear();

        button = new Rectangle(454, 425, 301, 63); //button to get into the game

        try { //import image title screen
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/EndScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates
     */
    private boolean update() {
        mh.update();
        //checks if the mouse is inside the rectangle
        if (button.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0) {
            gc.setVisible(false);
            return false;
        }
        return true;
    }

    //draw
    void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();

            gc.drawImage(image, 0, 0);
        }
    }

    public void start() {
        while (Main.gameState == 2) {
            update();
            draw();
            reset();
            gc.sleep(SLEEPTIME);
        }

        // return true;
    }
    public void reset() { //reset all variables

    }
}

