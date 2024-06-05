package GUI;
import hsa2.GraphicsConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class TitleScreen {

    //variables and class initializing
    private final int SLEEPTIME = 5;
    Rectangle button, help;
    BufferedImage image;
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    Color string = new Color (160, 82, 45, 50); //transparent color for buttons

    // set default settings
    public TitleScreen() {
        gc.setAntiAlias(true);
        gc.setLocationRelativeTo(null);
        gc.enableMouseMotion();
        gc.enableMouse();
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676")); //incase the image doesnt work
        gc.clear();

        try { //import image
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/TitleScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new Rectangle(454, 425, 301, 63); //button to get into the game
        help = new Rectangle( 948, 567, 225, 60); //button to get help

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
                //gc.setColor(buttons);
                //gc.drawRect(button.x, button.y, button.width, button.height);
                //gc.drawRect(help.x, help.y, help.width, help.height);

                if (help.contains(gc.getMouseX(), gc.getMouseY())) {    //check if mouse hovers over help
                    gc.setColor(Color.WHITE);
                   // gc.fillRect(760, 370, 300, 175);

                    Polygon info = new Polygon(); //thought bubble for text
                    info.addPoint(760, 370); //1
                    info.addPoint(1075, 370); //2
                    info.addPoint(1075, 545); //3
                    info.addPoint(1080, 565); //tip
                    info.addPoint(1050, 545); //tip
                    info.addPoint(760, 545);//4
                    gc.fillPolygon(info);

                    //draw string
                    gc.setColor(string);
                    gc.setFont( new Font( "Serif", Font.BOLD, 18) );
                    gc.drawString("String 1", 765,380);

                }

            }
        }
    }
