package core;

public class BasicRectangularMaze extends RectangularMaze {

    private final CellContent[][] cells;

    public BasicRectangularMaze(int width, int height) {
        super(width, height);

        cells = new CellContent[width][height];

        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                //the borders of the maze are considered walls initially
                cells[j][i] = i == 0 || j == 0 || i == height - 1 || j == width - 1 ? CellContent.Wall : CellContent.Empty;
            }
        }
    }

    @Override
    public void addWall(Coordinate2D cell) {
        ValidateCell(cell);
        cells[cell.getX()][cell.getY()] = CellContent.Wall;
    }

    @Override
    public void removeWall(Coordinate2D cell) {

        ValidateCell(cell);
        cells[cell.getX()][cell.getY()] = CellContent.Empty;
    }

    @Override
    public boolean hasWall(Coordinate2D cell) {
        ValidateCell(cell);
        return cells[cell.getX()][cell.getY()] == CellContent.Wall;
    }

    private enum CellContent {
        Empty, Wall
    }
}
