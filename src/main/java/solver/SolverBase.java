package solver;

import maze.Coordinate;
import maze.MazeBase;
import org.jetbrains.annotations.NotNull;

public abstract class SolverBase implements Solver {

    /**
     * Solve a maze. This sets the cells in the provided maze to be part of the solution path.
     *
     * @param maze  the maze to solve
     * @param start the start point
     * @param end   the end point
     * @return if the maze could be solved (i.e. if the end point could be reached from the start point)
     */
    public abstract <CoordinateType extends Coordinate, MazeType extends MazeBase<CoordinateType>> boolean solve(@NotNull MazeType maze, @NotNull CoordinateType start, @NotNull CoordinateType end);
}
