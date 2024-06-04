package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Grape extends SuperBall{

    public static final int DIAMETER = 60;

    public Grape(int x, int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/grape.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
