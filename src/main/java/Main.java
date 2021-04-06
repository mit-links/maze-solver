import creator.BasicRectangularMazeCreator;
import creator.algorithm.MazeCreationAlgorithmType;
import visualize.RectangularMazeVisualizer;

/**
 * Main class containing the main method
 */
public class Main {
    public static void main(String[] args) {
        var creator = new BasicRectangularMazeCreator();
        var maze = creator.Create(10, 5, MazeCreationAlgorithmType.Prim);
        var visualizer = new RectangularMazeVisualizer();
        visualizer.visualizeGeneric(maze);
    }
}