package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Cherry extends SuperBall {

    public static final int DIAMETER = 30;

    public Cherry(int x, int y) {
        super(x, y, DIAMETER);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/cherry.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
