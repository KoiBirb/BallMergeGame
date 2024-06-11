package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Pear extends SuperBall{

    public static final int DIAMETER = 240;

    public Pear(int x, int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/pear.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
