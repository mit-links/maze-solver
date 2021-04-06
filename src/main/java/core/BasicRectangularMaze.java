package core;

public class BasicRectangularMaze implements RectangularMaze {

    private final int width;
    private final int height;

    // walls on the bottom of a cell
    private final boolean[][] bottomWalls;

    //walls on the right of a cell
    private final boolean[][] rightWalls;

    public BasicRectangularMaze(int width, int height) {
        bottomWalls = new boolean[width][height];
        rightWalls = new boolean[width][height];

        //set walls in the bottom row
        for (var i = 0; i < width; i++) {
            bottomWalls[i][height - 1] = true;
        }

        //set walls in the right-most column
        for (var i = 0; i < height; i++) {
            rightWalls[width - 1][i] = true;
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean hasWallAbove(Coordinate2D cell) {
        ValidateCell(cell);
        if (cell.getY() == 0) {
            //top row -> always considered to have a wall
            return true;
        }

        //to check if this cell has a wall above is the same as checking if the cell above has a wall below
        return hasWallBelow(new Coordinate2D(cell.getX(), cell.getY() - 1));
    }

    @Override
    public boolean hasWallBelow(Coordinate2D cell) {
        ValidateCell(cell);
        return bottomWalls[cell.getX()][cell.getY()];
    }

    @Override
    public boolean hasWallLeft(Coordinate2D cell) {
        ValidateCell(cell);
        if (cell.getX() == 0) {
            //left-most column -> always considered to have a wall
            return true;
        }

        //to check if this cell has a wall on the left is the same as checking if the cell on the left has a wall on the right
        return hasWallRight(new Coordinate2D(cell.getX() - 1, cell.getY()));
    }

    @Override
    public boolean hasWallRight(Coordinate2D cell) {
        ValidateCell(cell);
        return rightWalls[cell.getX()][cell.getY()];
    }

    @Override
    public void addWallAbove(Coordinate2D cell) {
        ValidateCell(cell);
        if (cell.getY() == 0) {
            //top row -> nothing to add as it's always considered to have a wall
            return;
        }

        //adding a wall above this cell is the same as adding a wall below the cell above
        addWallBelow(new Coordinate2D(cell.getX(), cell.getY() - 1));
    }

    @Override
    public void addWallBelow(Coordinate2D cell) {
        ValidateCell(cell);
        bottomWalls[cell.getX()][cell.getY()] = true;
    }

    @Override
    public void addWallLeft(Coordinate2D cell) {
        ValidateCell(cell);
        if (cell.getX() == 0) {
            //left-most column -> nothing to add as it's always considered to have a wall
            return;
        }

        //adding a wall to the left of this cell is the same as adding a wall to the right of the cell to the left
        addWallRight(new Coordinate2D(cell.getX() - 1, cell.getY()));
    }

    @Override
    public void addWallRight(Coordinate2D cell) {
        ValidateCell(cell);
        rightWalls[cell.getX()][cell.getY()] = true;
    }

    private void ValidateCell(Coordinate2D cell) {
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
