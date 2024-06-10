package GUI;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class TitleScreen {

    //variables and class initializing
    private final int SLEEPTIME = 5;
    public static Rectangle button, help;
    BufferedImage image, image2;
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    public static MusicHandler mh = new MusicHandler();
   // Color string = new Color (160, 82, 45); //transparent color for buttons

    // set default settings
    public TitleScreen() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676")); //incase the image doesnt work
        gc.clear();

        try { //import image title screen
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/TitleScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { //import image title screen + info
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/TitleScreenInfo.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new Rectangle(454, 425, 301, 63); //button to get into the game
        help = new Rectangle( 948, 567, 225, 60); //button to get help

    }

    /**
     * Starts
     */
    public boolean start() {
        while (update()) {
            draw();
            gc.sleep(SLEEPTIME);
        }

        return true;
    }

    /**
     * Updates
     */
    private boolean update() {
        mh.update();
        //checks if the mouse is inside the rectangle
        if (button.contains(gc.getMouseX(), gc.getMouseY())&&gc.getMouseClick() > 0) {
            gc.setVisible(false);
            return false;
        }
        return true;
    }

        /**
         * Draws
         */
        void draw () {
            synchronized (gc) {
                gc.clear();
                gc.clearRotation();

                gc.drawImage(image,0,0);

                if (help.contains(gc.getMouseX(), gc.getMouseY())) {    //check if mouse hovers over help
                    gc.setColor(Color.WHITE);
                    mh.update();
                    gc.drawImage(image2,0,0); //display help


                }

            }
        }
    }
