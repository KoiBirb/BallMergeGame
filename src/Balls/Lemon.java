package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Lemon extends SuperBall{

    public Lemon(int x, int y) {
        super(x, y, 80);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/lemon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
