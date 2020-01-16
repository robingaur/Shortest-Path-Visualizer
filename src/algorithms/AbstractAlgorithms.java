package algorithms;

import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import java.awt.*;

public abstract class AbstractAlgorithms implements Runnable, AlgorithmsInterface {

    protected NodeType[][] graph;
    protected int graphWidth;
    protected int graphHeight;
    protected Point source;
    private double animationDelay;
    private RectangularGrid grid;

    public AbstractAlgorithms(NodeType[][] graph, RectangularGrid grid,
                              Point source) {
        this.graph = graph;
        this.graphWidth = graph.length;
        this.graphHeight = graph[0].length;
        this.grid = grid;
        this.source = source;
        this.animationDelay = 10;
    }

    @Override
    public void run() {
        this.findPath();
    }

    abstract void findPath();

    void fillQueueNode(int row, int col) {
        this.grid.fillRectangularGrid(row, col, NodeColor.QUEUE_COLOR);
    }

    void fillVisitedNode(int row, int col) {
        this.grid.fillRectangularGrid(row, col, NodeColor.VISITED_COLOR);
    }

    @Override
    public void setAnimationDelay(double delay) {
        this.animationDelay = delay;
    }

    @Override
    public double getAnimationDelay() {
        return this.animationDelay;
    }
}
