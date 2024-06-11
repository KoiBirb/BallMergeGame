/**
 * TitleScreen.java
 * Mariana Trillos
 * June 12, 2024
 * Displays Title screen and uses buttons to exit
 */

package GUI;
import Main.Main;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class TitleScreen {

    private final Rectangle button, help;
    private BufferedImage image, image2;
    public static final GraphicsConsole gc = new GraphicsConsole(1200, 650);
    private final MusicHandler mh;

    /**
     * Constructor
     */
    public TitleScreen() {
        mh = Main.mh;

        setUp();

        try { //Title screen
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/TitleScreen.jpg")));
        } catch (Exception e) {
            System.out.println("Image Failed to Load");
        }

        try { //Info
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/TitleScreenInfo.jpg")));
        } catch (Exception e) {
            System.out.println("Image Failed to Load");
        }

        button = new Rectangle(454, 425, 301, 63); //button to get into the game
        help = new Rectangle( 948, 567, 225, 60); //button to get help

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
        gc.setTitle("SUIKA GAME");
        gc.setBackgroundColor(Color.decode("#eab676"));
    }

    /**
     * Starts title screen
     */
    public void start() {
        while (Main.gameState == 0) {
            update();
            draw();
            gc.sleep(Main.SLEEPTIME);
        }
    }

    /**
     * Updates music and checks for button click
     */
    private void update() {
        if (button.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0)
            Main.gameState = 1;

        if (help.contains(gc.getMouseX(), gc.getMouseY())){
            mh.playHelpSoundEffect(true);
            if(!help.contains(gc.getMouseX(), gc.getMouseY())){
                mh.playHelpSoundEffect(false);
            }
        }
    }

        /**
         * Draws title screen and help screen
         */
        void draw () {
            synchronized (gc) {
                gc.clear();
                gc.clearRotation();
                gc.drawImage(image,0,0);

                if (help.contains(gc.getMouseX(), gc.getMouseY())) {
                    gc.setColor(Color.WHITE);
                    gc.drawImage(image2,0,0);
                }
            }
        }
    }
