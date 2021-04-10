package creator.algorithm;

import maze.Coordinate2D;
import maze.MazeCellType;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * The algorithm visits unvisited neighbors and adds them to the maze, if no loop is created.
 */
public class NoLoopAlgorithm extends MazeCreationAlgorithmBase<RectangularMaze> {
    public NoLoopAlgorithm() {
        super(MazeCreationAlgorithmType.NO_LOOP);
    }

    @Override
    public void createMaze(@NotNull RectangularMaze mazeTemplate) {
        //1. set the entire maze to walls
        mazeTemplate.setAllToWalls();

        //2. pick start point of maze
        var wallList = new ArrayList<Coordinate2D>();
        var visited = new HashSet<Coordinate2D>();
        var origin = mazeTemplate.getTopLeft();
        wallList.add(origin);

        //3. while there are still walls in the wall list, add cells to maze
        var random = new Random();
        while (!wallList.isEmpty()) {
            //pick random element from wall list
            var index = random.nextInt(wallList.size());
            var cell = wallList.get(index);
            wallList.remove(index);

            //get the unvisited neighbors and the number of non-wall neighbors
            var unvisitedNeighbors = new ArrayList<Coordinate2D>();
            var nonWallNeighbors = 0;

            for (var neighbor : mazeTemplate.getNeighbors(cell)) {
                if (!visited.contains(neighbor)) {
                    unvisitedNeighbors.add(neighbor);
                }
                if (!mazeTemplate.getCellType(neighbor).equals(MazeCellType.WALL)) {
                    nonWallNeighbors++;
                }
            }

            if (nonWallNeighbors <= 1) {
                //we can remove the wall without creating a loop
                mazeTemplate.setCellType(cell, MazeCellType.EMPTY);
                wallList.addAll(unvisitedNeighbors);
            }

            //prepare for the next iteration
            visited.add(cell);
        }
    }
}
