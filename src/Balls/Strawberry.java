package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Strawberry extends SuperBall{
    public Strawberry(int x, int y) {
        super(x, y, 40);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/strawberry.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
