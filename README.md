# Maze Solver

This is a little Java tool that creates and solves mazes. It can also visually display the mazes and solutions using
JavaFX.

There's not much purpose to the tool, it's just for fun :)

## Get Started

### Prerequisites

- JDK 15+
- [JavaFX SDK](https://gluonhq.com/products/javafx/)

### Installation

1. Download repository
2. Open project in IntelliJ (or another IDE, steps might differ in that case)
3. Adapt JavaFX SDK path in the run configuration (.idea/runConfigurations/Main.xml) to your local JavaFX SDK folder
4. Configure the <code>Main</code> class as desired (see below)
5. Build the project (Maven) and run <code>Main.main</code> (with the previously adapted run configuration)
6. With the default settings, a window should appear with a solved maze (or an unsolved maze in some corner cases)

## Configuration

There's no configuration file (yet). Use the fields in the <code>Main</code> class to configure the size of the maze and
the algorithm to create and solve the maze. Note that mazes whose size exceed your screen's resolution cannot be
displayed.

Currently supported <em>creation</em> algorithms are:

- Depth-first search (DFS)
- Minimum spanning tree (Prim)

Currently supported <em>solving</em> algorithms are:

- Depth-first search (DFS) 
