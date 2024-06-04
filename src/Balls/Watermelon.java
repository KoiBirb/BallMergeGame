package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Watermelon extends SuperBall {

    public Watermelon(int x, int y) {
        super(x, y, 160);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/watermelon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
