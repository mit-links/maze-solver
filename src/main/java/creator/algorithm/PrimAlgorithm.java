package creator.algorithm;

import core.mazes.Coordinate2D;
import core.mazes.RectangularMaze;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * Create a maze by using Prim's algorithm.
 * This creates a maze that is a minimum spanning tree, i.e. it has no loops.
 */
public class PrimAlgorithm extends MazeCreationAlgorithmBase<RectangularMaze> {
    public PrimAlgorithm() {
        super(MazeCreationAlgorithmType.Prim);
    }

    @Override
    public void createMaze(@NotNull RectangularMaze mazeTemplate) {
        var width = mazeTemplate.getWidth();
        var height = mazeTemplate.getHeight();

        //1. set the entire maze to walls
        for (var y = 0; y < height; y++) {
            for (var x = 0; x < width; x++) {
                mazeTemplate.addWall(new Coordinate2D(x, y));
            }
        }

        //2. pick start point of maze
        var wallList = new ArrayList<Coordinate2D>();
        var visited = new boolean[mazeTemplate.getWidth()][mazeTemplate.getHeight()];
        var origin = new Coordinate2D(0, 0);
        wallList.add(origin);

        //TODO FIX
        //3. while there are still walls in the wall list, add cells to maze
        var random = new Random();
        while (!wallList.isEmpty()) {
            //pick random element from wall list
            var index = random.nextInt(wallList.size());
            var cell = wallList.get(index);
            wallList.remove(index);

            //get the unvisited neighbors and the number of non-wall neighbors
            var unvisitedNeighbors = new ArrayList<Coordinate2D>();
            var neighbors = new Coordinate2D[]{mazeTemplate.getCellLeft(cell), mazeTemplate.getCellRight(cell), mazeTemplate.getCellAbove(cell), mazeTemplate.getCellBelow(cell)};
            var nonWallNeighbors = 0;

            for (var neighbor : neighbors) {
                if (neighbor == null) {
                    continue;
                }
                if (!visited[neighbor.getX()][neighbor.getY()]) {
                    unvisitedNeighbors.add(neighbor);
                }
                if (!mazeTemplate.hasWall(neighbor)) {
                    nonWallNeighbors++;
                }
            }

            if (nonWallNeighbors <= 1) {
                //we can remove the wall without creating a loop
                mazeTemplate.removeWall(cell);
            }

            //prepare for the next iteration
            visited[cell.getX()][cell.getY()] = true;
            wallList.addAll(unvisitedNeighbors);
        }
    }
}
