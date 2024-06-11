/*
 * Grape.java
 * Leo Bogaert
 * June 12, 2024
 * Grape object
 */
package Balls;

public class Grape extends SuperBall{

    public static final int DIAMETER = 80;

    /**
     * Grape constructor
     * @param x int position of the grape
     * @param y int position of the grape
     */
    public Grape(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/grape.png");
    }
}
