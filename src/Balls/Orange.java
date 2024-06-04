package Balls;

import javax.imageio.ImageIO;
import java.util.Objects;

public class Orange extends SuperBall{

    public Orange(int x, int y) {
        super(x, y, 100);
        try {
            super.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Assets/Fruit/orange.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
