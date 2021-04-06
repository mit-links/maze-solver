package creator.algorithm;

import core.mazes.Maze;
import org.jetbrains.annotations.NotNull;

public abstract class MazeCreationAlgorithmBase<MazeType extends Maze> implements MazeCreationAlgorithm {
    private final MazeCreationAlgorithmType type;

    protected MazeCreationAlgorithmBase(MazeCreationAlgorithmType type) {
        this.type = type;
    }

    public abstract @NotNull MazeType CreateMaze(@NotNull MazeType mazeTemplate);

    @Override
    public MazeCreationAlgorithmType getType() {
        return type;
    }
}
