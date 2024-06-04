package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Pear extends SuperBall{

    public Pear(int x, int y) {
        super(x, y, 140);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/pear.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
