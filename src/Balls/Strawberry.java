package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Strawberry extends SuperBall{

    public static final int DIAMETER = 60;

    public Strawberry(int x, int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/strawberry.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
