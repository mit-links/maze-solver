package core.mazes;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate2D)) return false;
        Coordinate2D that = (Coordinate2D) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
