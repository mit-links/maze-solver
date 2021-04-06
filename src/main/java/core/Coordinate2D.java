package core;

/**
 * A 2D coordinate, i.e. a coordinate that has an x and a y value
 */
public class Coordinate2D implements Coordinate {
    private final int x;
    private final int y;

    public Coordinate2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
