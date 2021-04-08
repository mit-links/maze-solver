package creator;

import creator.algorithm.MazeCreationAlgorithmBase;
import creator.algorithm.MazeCreationAlgorithmType;
import maze.Maze;
import org.jetbrains.annotations.NotNull;

/**
 * Creates mazes
 *
 * @param <MazeType> the type of mazes this class creates
 */
public abstract class MazeCreatorBase<MazeType extends Maze> implements MazeCreator {
    /**
     * Create a maze
     *
     * @param maze          the maze template to fill
     * @param algorithmType the type of algorithm to use to crate the maze
     */
    protected void create(MazeType maze, MazeCreationAlgorithmType algorithmType) {
        var algorithm = getAlgorithm(algorithmType);
        algorithm.createMaze(maze);
    }

    protected @NotNull MazeCreationAlgorithmBase<MazeType> getAlgorithm(MazeCreationAlgorithmType algorithmType) {
        throw new IllegalArgumentException("Unsupported maze creation algorithm: " + algorithmType);
    }
}
