package algorithms;

import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import java.awt.*;

public abstract class AbstractAlgorithms implements Runnable, AlgorithmsInterface {

    protected NodeType[][] graph;
    protected int graphWidth;
    protected int graphHeight;
    private double animationDelay;
    private RectangularGrid grid;

    public AbstractAlgorithms(NodeType[][] graph, int graphWidth, int graphHeight, RectangularGrid grid) {
        this.graph = graph;
        this.graphWidth = graphWidth;
        this.graphHeight = graphHeight;
        this.grid = grid;
        this.animationDelay = 10;
    }

    @Override
    public void run() {

    }

    abstract void findPath(Point source, Point destination);

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
