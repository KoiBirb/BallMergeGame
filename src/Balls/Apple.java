/*
 * Apple.java
 * Leo Bogaert
 * June 12, 2024
 * Apple object
 */
package Balls;

public class Apple extends SuperBall{

    public static final int DIAMETER = 180;

    /**
     * Apple constructor
     * @param x int position of the apple
     * @param y int position of the apple
     */
    public Apple(int x,int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/apple.png");
    }
}
