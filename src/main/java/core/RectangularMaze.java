package core;

/**
 * A rectangular maze.
 * x coordinate goes from left to right, y coordinate from top to bottom.
 * origin (0/0) is at the top-left cells (this entails only positive coordinates).
 */
public abstract class RectangularMaze extends MazeBase<Coordinate2D> {
    private final int width;
    private final int height;

    public RectangularMaze(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void addWall(Coordinate2D cell);

    public abstract void removeWall(Coordinate2D cell);

    public abstract boolean hasWall(Coordinate2D cell);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected void ValidateCell(Coordinate2D cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Cell can't be null");
        }

        if (cell.getX() < 0 || cell.getX() >= width) {
            throw new IndexOutOfBoundsException("x coordinate of cell is out of bounds: %d. Must be in [0, %d)".formatted(cell.getX(), width));
        }
        if (cell.getY() < 0 || cell.getY() >= height) {
            throw new IndexOutOfBoundsException("y coordinate of cell is out of bounds: %d. Must be in [0, %d)".formatted(cell.getY(), height));
        }
    }
}