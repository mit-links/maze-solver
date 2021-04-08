import creator.BasicRectangularMazeCreator;
import creator.algorithm.MazeCreationAlgorithmType;
import javafx.application.Application;
import javafx.stage.Stage;
import solver.DFSSolver;
import visualize.RectangularMazeVisualizer;

/**
 * Main class containing the main method
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        var width = 200;
        var height = 75;

        //create maze
        var start = System.currentTimeMillis();
        var creator = new BasicRectangularMazeCreator();
        var maze = creator.Create(width, height, MazeCreationAlgorithmType.NO_LOOP);
        var end = System.currentTimeMillis();
        System.out.printf("Created maze of type %s. Took %d ms%n", creator.getClass().toString(), end - start);

        //solve maze
        start = System.currentTimeMillis();
        var solver = new DFSSolver();
        var success = solver.solve(maze, maze.getTopLeft(), maze.getBottomRight());
        end = System.currentTimeMillis();
        System.out.printf("Solved maze of type %s. Success: %s. Took %d ms%n", creator.getClass().toString(), success, end - start);

        //visualize maze
        var visualizer = new RectangularMazeVisualizer(stage);
        visualizer.visualizeMaze(maze);
    }
}