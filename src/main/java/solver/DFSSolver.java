package solver;

import maze.Coordinate;
import maze.MazeBase;
import maze.MazeCellType;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Solves a maze with depth-first search *
 */
public class DFSSolver extends SolverBase {

    @Override
    public <CoordinateType extends Coordinate, MazeType extends MazeBase<CoordinateType>> boolean solve(@NotNull MazeType maze, @NotNull CoordinateType start, @NotNull CoordinateType end) {
        var visited = new HashSet<CoordinateType>();

        var stack = new Stack<CoordinateType>();
        stack.push(start);

        while (!stack.empty()) {
            var next = stack.peek();
            visited.add(next);

            if (next.equals(end)) {
                //mark solution
                for (var cell : stack) {
                    maze.setCellType(cell, MazeCellType.SOLUTION_PATH);
                }
                return true;
            }

            var neighbors = maze.getNeighborsOfType(next, MazeCellType.EMPTY);
            var unvisitedNeighbors = neighbors.stream().filter(c -> !visited.contains(c)).collect(Collectors.toList());

            if (unvisitedNeighbors.isEmpty()) {
                //no unvisited neighbors left -> pop the current element
                stack.pop();
            } else {
                //put all unvisited neighbors on the stack
                stack.add(unvisitedNeighbors.get(0));
            }
        }

        //no path to end was found -> mark all visited cells as error nodes
        for (var visitedCell : visited) {
            maze.setCellType(visitedCell, MazeCellType.ERROR_PATH);
        }

        return false;
    }

    @Override
    public SolverType getSolverType() {
        return SolverType.DFS;
    }
}
