/*
 * Orange.java
 * Leo Bogaert
 * June 12, 2024
 * Orange object
 */
package Balls;

public class Orange extends SuperBall{

    public static final int DIAMETER = 130;

    /**
     * Orange constructor
     * @param x int position of the orange
     * @param y int position of the orange
     */
    public Orange(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/orange.png");
    }
}
