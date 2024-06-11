/*
 * Cherry.java
 * Leo Bogaert
 * June 12, 2024
 * Cherry object
 */
package Balls;

public class Cherry extends SuperBall {

    public static final int DIAMETER = 40;

    /**
     * Cherry constructor
     * @param x int position of the cherry
     * @param y int position of the cherry
     */
    public Cherry(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/cherry.png");
    }
}
