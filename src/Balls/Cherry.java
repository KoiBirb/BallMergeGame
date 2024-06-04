package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Cherry extends SuperBall {

    public Cherry(int x, int y) {
        super(x, y, 20);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/cherry.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
