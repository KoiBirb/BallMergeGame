package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Grape extends SuperBall{

    public Grape(int x, int y) {
        super(x, y, 60);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/grape.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
