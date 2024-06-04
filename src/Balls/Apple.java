package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Apple extends SuperBall{

    public static final int DIAMETER = 160;

    public Apple(int x,int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/apple.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
