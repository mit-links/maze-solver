package creator;

import core.mazes.Maze;
import creator.algorithm.MazeCreationAlgorithmBase;
import creator.algorithm.MazeCreationAlgorithmType;
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
     * @param mazeTemplate  the maze template to start from
     * @param algorithmType the type of algorithm to use to crate the maze
     * @return the created maze
     */
    protected @NotNull MazeType Create(MazeType mazeTemplate, MazeCreationAlgorithmType algorithmType) {
        var algorithm = getAlgorithm(algorithmType);
        return algorithm.CreateMaze(mazeTemplate);
    }

    protected @NotNull MazeCreationAlgorithmBase<MazeType> getAlgorithm(MazeCreationAlgorithmType algorithmType) {
        throw new IllegalArgumentException("Unsupported maze creation algorithm: " + algorithmType);
    }
}
