package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Lemon extends SuperBall{

    public static final int DIAMETER = 90;

    public Lemon(int x, int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/lemon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
