package creator.algorithm;

import core.mazes.Maze;
import org.jetbrains.annotations.NotNull;

public abstract class MazeCreationAlgorithmBase<MazeType extends Maze> implements MazeCreationAlgorithm {
    private final MazeCreationAlgorithmType type;

    protected MazeCreationAlgorithmBase(MazeCreationAlgorithmType type) {
        this.type = type;
    }

    /**
     * Create a maze
     *
     * @param mazeTemplate the maze template to fill
     */
    public abstract void createMaze(@NotNull MazeType mazeTemplate);

    @Override
    public MazeCreationAlgorithmType getType() {
        return type;
    }
}
