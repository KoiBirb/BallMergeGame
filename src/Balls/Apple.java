package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Apple extends SuperBall{

    public Apple(int x,int y) {
        super(x, y, 120, 120);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/apple.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
