package core;

/**
 * A rectangular maze.
 * x coordinate goes from left to right, y coordinate from top to bottom.
 * origin (0/0) is at the top-left cells (this entails only positive coordinates).
 */
public interface RectangularMaze extends Maze<Coordinate2D> {
    int getWidth();

    int getHeight();

    boolean hasWallAbove(Coordinate2D cell);

    boolean hasWallBelow(Coordinate2D cell);

    boolean hasWallLeft(Coordinate2D cell);

    boolean hasWallRight(Coordinate2D cell);

    void addWallAbove(Coordinate2D cell);

    void addWallBelow(Coordinate2D cell);

    void addWallLeft(Coordinate2D cell);

    void addWallRight(Coordinate2D cell);
}