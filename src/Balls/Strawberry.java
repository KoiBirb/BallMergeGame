/*
 * Strawberry.java
 * Leo Bogaert
 * June 12, 2024
 * Strawberry object
 */
package Balls;

public class Strawberry extends SuperBall{

    public static final int DIAMETER = 60;

    /**
     * Strawberry constructor
     * @param x int position of the strawberry
     * @param y int position of the strawberry
     */
    public Strawberry(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/strawberry.png");
    }
}
