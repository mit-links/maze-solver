package creator;

import creator.algorithm.DFSMazeCreationAlgorithm;
import creator.algorithm.MazeCreationAlgorithmBase;
import creator.algorithm.MazeCreationAlgorithmType;
import creator.algorithm.PrimMazeCreationAlgorithm;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

/**
 * Creates rectangular mazes
 */
public abstract class RectangularMazeCreator extends MazeCreatorBase<RectangularMaze> {

    /**
     * Create a rectangular maze by using the provided algorithm type
     *
     * @param width                     the width of the maze
     * @param height                    the height of the maze
     * @param mazeCreationAlgorithmType the type of algorithm that should be used to create the maze
     * @return the maze created according to the provided arguments
     */
    public @NotNull RectangularMaze Create(int width, int height, MazeCreationAlgorithmType mazeCreationAlgorithmType) {
        Validate(width, height);

        var maze = CreateMazeTemplate(width, height);
        create(maze, mazeCreationAlgorithmType);

        return maze;
    }

    /**
     * Create a maze template that can be completed by an algorithm later
     */
    protected abstract @NotNull RectangularMaze CreateMazeTemplate(int width, int height);

    @Override
    protected @NotNull MazeCreationAlgorithmBase<RectangularMaze> getAlgorithm(MazeCreationAlgorithmType algorithmType) {
        return switch (algorithmType) {
            case PRIM_RANDOMIZED -> new PrimMazeCreationAlgorithm();
            case DFS -> new DFSMazeCreationAlgorithm();
        };
    }

    private void Validate(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
    }
}
