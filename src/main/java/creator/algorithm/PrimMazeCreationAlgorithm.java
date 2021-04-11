package creator.algorithm;

import maze.Coordinate2D;
import maze.MazeCellType;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Create a maze using Prim's algorithm (i.e. by creating a minimal spanning tree)
 */
public class PrimMazeCreationAlgorithm extends MazeCreationAlgorithmBase<RectangularMaze> {
    public PrimMazeCreationAlgorithm() {
        super(MazeCreationAlgorithmType.PRIM_RANDOMIZED);
    }

    @Override
    public void createMaze(@NotNull RectangularMaze mazeTemplate) {
        //1. set the entire maze to walls
        mazeTemplate.setAllToWalls();

        //2. pick start point of maze
        var visited = new HashSet<Coordinate2D>();

        var origin = mazeTemplate.getStart();
        visited.add(origin);
        mazeTemplate.setCellType(origin, MazeCellType.EMPTY);

        var wallList = new ArrayList<>(mazeTemplate.getNeighborsOfType(origin, MazeCellType.WALL));

        //3. take walls out of list and add them to the maze, if only one of the two cells that the wall divides is visited
        var random = new Random();
        while (!wallList.isEmpty()) {
            var index = random.nextInt(wallList.size());
            var cell = wallList.get(index);
            wallList.remove(index);
            if (visited.contains(cell)) {
                continue;
            }

            visited.add(cell);

            var numberOfEmptyNeighbors = mazeTemplate.getNeighbors(cell).stream().filter(c -> mazeTemplate.getCellType(c) == MazeCellType.EMPTY).count();

            //the cell can be added to the maze, if at most one neighbor has been added to the maze
            if (numberOfEmptyNeighbors <= 1) {
                mazeTemplate.setCellType(cell, MazeCellType.EMPTY);
                wallList.addAll(mazeTemplate.getNeighborsOfType(cell, MazeCellType.WALL));
            }
        }
    }
}
