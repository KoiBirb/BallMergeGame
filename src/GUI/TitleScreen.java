package GUI;
import hsa2.GraphicsConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class TitleScreen {

    private final int SLEEPTIME = 5;
    Rectangle button;
    BufferedImage image;

    // initialize classes
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);

    // set default settings
    public TitleScreen() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676"));
        gc.clear();

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/TitleScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new Rectangle(454, 425, 301, 60);
    }

    /**
     * Starts the game
     */
    public boolean start() {
        while (update()) {
            draw();
            gc.sleep(SLEEPTIME);
        }

        return true;
    }

    /**
     * Updates the game
     */
    private boolean update() {
        if (gc.getMouseClick() > 0) {    //checks if the mouse is inside the rectangle, if so it is moved diagonally
            if (button.contains(gc.getMouseX(), gc.getMouseY())) {
                gc.setVisible(false);
                return false;
            }
        }
        return true;
    }

        /**
         * Draws the game
         */
        void draw () {
            synchronized (gc) {
                gc.clear();
                gc.clearRotation();

                gc.drawImage(image,0,0);
                gc.setColor(Color.GREEN);
                gc.drawRect(button.x, button.y, button.width, button.height);


            }
        }
    }
