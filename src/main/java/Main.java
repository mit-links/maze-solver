import creator.BasicRectangularMazeCreator;
import creator.algorithm.MazeCreationAlgorithmType;
import javafx.application.Application;
import javafx.stage.Stage;
import solver.DFSSolver;
import solver.SolverBase;
import solver.SolverType;
import visualization.RectangularMazeVisualizer;

/**
 * Main class containing the main method
 */
public class Main extends Application {

    //Change these fields to configure the behavior of the application
    private final int width = 150;
    private final int height = 75;
    private final MazeCreationAlgorithmType algorithmType = MazeCreationAlgorithmType.DFS;
    private final SolverType solverType = SolverType.DFS;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //create maze
        var start = System.currentTimeMillis();
        var creator = new BasicRectangularMazeCreator();
        var maze = creator.Create(width, height, algorithmType);
        var end = System.currentTimeMillis();
        System.out.printf("Created maze of type %s with algorithm %s and size %d x %d. Took %d ms%n", creator.getClass().getSimpleName(), algorithmType, height, width, end - start);

        //solve maze
        start = System.currentTimeMillis();
        var solver = getSolver();
        var success = solver.solve(maze, maze.getStart(), maze.getEnd());
        end = System.currentTimeMillis();
        System.out.printf("Solved maze using solver %s. Success: %s. Took %d ms%n", solver.getClass().getSimpleName(), success, end - start);

        //visualize maze
        var visualizer = new RectangularMazeVisualizer(stage);
        visualizer.visualizeMaze(maze);
    }

    private SolverBase getSolver() {
        return switch (solverType) {
            case DFS -> new DFSSolver();
        };
    }
}