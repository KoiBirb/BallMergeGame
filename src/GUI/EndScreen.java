package GUI;
import Main.Main;
import Sound.MusicHandler;
import hsa2.GraphicsConsole;
import Main.Sort;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import Main.GamePanel;

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

        button = new Rectangle(454, 480, 301, 63); //button to get into the game

        try { //import image title screen
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/GUI/EndScreen.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        gc.clear();
    }

    /**
     * Updates
     */
    private void update() {
        mh.update();
        //checks if the mouse is inside the rectangle
        if (button.contains(gc.getMouseX(), gc.getMouseY()) && gc.getMouseClick() > 0) {
            Main.gameState = 1;
        }
    }

    //draw
    void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();
            gc.setColor(Color.RED);
            gc.drawImage(image, 0, 0);
           //gc.drawRect(button.x, button.y, 301, 63);
        }
    }

    public void start() {
        if (ScoreBoard.score > ScoreBoard.topScores[6]) {
            ScoreBoard.topScores[6] = ScoreBoard.score;
        }
        ScoreBoard.topScores = Sort.mergeSort(ScoreBoard.topScores);

        while (Main.gameState == 2) {
            update();
            draw();
            gc.sleep(SLEEPTIME);
        }
    }
}

