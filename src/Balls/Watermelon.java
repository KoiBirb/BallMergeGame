package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Watermelon extends SuperBall {

    public static final int DIAMETER = 160;

    public Watermelon(int x, int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/watermelon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
