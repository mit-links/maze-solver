package creator;

import core.mazes.BasicRectangularMaze;
import core.mazes.RectangularMaze;
import org.jetbrains.annotations.NotNull;

/**
 * Creates a {@link BasicRectangularMaze}
 */
public class BasicRectangularMazeCreator extends RectangularMazeCreator {

    @Override
    protected @NotNull RectangularMaze CreateMazeTemplate(int width, int height) {
        return new BasicRectangularMaze(width, height);
    }
}
