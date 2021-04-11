package creator.algorithm;

import maze.Coordinate2D;
import maze.MazeCellType;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

public class DFSMazeCreationAlgorithm extends MazeCreationAlgorithmBase<RectangularMaze> {

    public DFSMazeCreationAlgorithm() {
        super(MazeCreationAlgorithmType.DFS);
    }

    @Override
    public void createMaze(@NotNull RectangularMaze mazeTemplate) {
        mazeTemplate.setAllToWalls();

        var start = mazeTemplate.getStart();
        var end = mazeTemplate.getEnd();
        mazeTemplate.setCellType(start, MazeCellType.EMPTY);

        var stack = new Stack<Coordinate2D>();
        var visited = new HashSet<Coordinate2D>();
        stack.push(start);
        while (!stack.empty()) {
            var cell = stack.peek();
            visited.add(cell);

            var neighbors = mazeTemplate.getNeighbors(cell);
            var unvisitedNeighbors = neighbors.stream().filter(c -> !visited.contains(c)).collect(Collectors.toList());
            if (unvisitedNeighbors.isEmpty()) {
                //no more neighbors left to visit
                stack.pop();
                continue;
            }

            var emptyNeighbors = mazeTemplate.getNeighborsOfType(cell, MazeCellType.EMPTY).stream().filter(c -> mazeTemplate.getCellType(c) == MazeCellType.EMPTY);
            var canAdd = emptyNeighbors.count() <= 1;
            if (canAdd) {
                mazeTemplate.setCellType(cell, MazeCellType.EMPTY);
            } else {
                stack.pop();
            }

            if (mazeTemplate.getCellType(cell) == MazeCellType.EMPTY) {
                Coordinate2D next;

                //to guarantee a solution, the end point has to be taken, if possible
                if (unvisitedNeighbors.contains(end)) {
                    next = end;
                } else {
                    next = unvisitedNeighbors.get(new Random().nextInt(unvisitedNeighbors.size()));
                }
                stack.push(next);
            }
        }
    }
}
