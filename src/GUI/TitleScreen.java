package GUI;
import hsa2.GraphicsConsole;
import java.awt.*;

public class TitleScreen {

    private final int SLEEPTIME = 5;
    Rectangle button;

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

        button = new Rectangle(300,450,80,10);
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

    }

    /**
     * Draws the game
     */
    private void draw() {
        synchronized (gc) {
            gc.clear();
            gc.clearRotation();
            gc.setColor(Color.GREEN);
            gc.drawRect(button.x, button.y, button.width, button.height);


        }
    }
}
