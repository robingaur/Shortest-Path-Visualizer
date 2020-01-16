package algorithms;

import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGridInterface;

import java.awt.*;

public abstract class AbstractAlgorithms implements  AlgorithmsInterface {

    protected NodeType[][] graph;
    protected int graphWidth;
    protected int graphHeight;
    protected Point source;
    private int animationDelay;
    private RectangularGridInterface grid;

    public AbstractAlgorithms(NodeType[][] graph, RectangularGridInterface grid,
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

    protected void fillQueueNode(int row, int col) {
        this.grid.fillRectangularGrid(row, col, NodeColor.IN_QUEUE_COLOR);
        try {
            Thread.sleep(this.getAnimationDelay());
        } catch (InterruptedException ex) {
        }
    }

    protected void fillVisitedNode(int row, int col) {
        this.grid.fillRectangularGrid(row, col, NodeColor.VISITED_COLOR);
        try {
            Thread.sleep(this.getAnimationDelay());
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void setAnimationDelay(int delay) {
        this.animationDelay = delay;
    }

    @Override
    public int getAnimationDelay() {
        return this.animationDelay;
    }
}
