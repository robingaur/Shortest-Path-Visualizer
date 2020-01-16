package GUI;

import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class MainCanvas extends JPanel implements MainCanvasInterface {

    private JFrame frame;
    private final int GRAPH_WIDTH;
    private final int GRAPH_HEIGHT;
    private NodeType graph[][];
    private Point sourceNode;
    private Point destinationNode;
    private NodeType currentNodeStage;
    private boolean isOneTimeDeclared = false;

    public MainCanvas() {
        try {
            EventQueue.invokeAndWait(new EventQueueThread(this));
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

        // Set the Focus on frame, if not keyListener will not work.
        this.setFocusable(true);
        this.currentNodeStage = NodeType.MARKED; // Default Node Stage

        this.GRAPH_WIDTH = 80; // Default Graph Width
        this.GRAPH_HEIGHT = 40; // Default Graph Height
        this.graph = new NodeType[this.GRAPH_WIDTH][this.GRAPH_HEIGHT];

        this.resetCanvas();
    }

    public void resetCanvas() {

        for (int i = 0; i < this.GRAPH_WIDTH; i++) {
            for (int j = 0; j < this.GRAPH_HEIGHT; j++) {
                this.graph[i][j] = NodeType.NOT_VISITED; // Default Node Type
            }
        }

        // Setting Default Source Node
        this.sourceNode = new Point(0, 0);
        this.setNodeType(this.sourceNode, NodeType.SOURCE);

        // Setting Default Destination Node
        this.destinationNode = new Point(this.GRAPH_WIDTH - 1, this.GRAPH_HEIGHT - 1);
        this.setNodeType(this.destinationNode, NodeType.DESTINATION);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        RectangularGrid grid = new RectangularGrid(g, super.getWidth(), super.getHeight(),
                this.GRAPH_WIDTH, this.GRAPH_HEIGHT);

        // White Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        // Black Border
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, super.getWidth(), super.getHeight());

        for (int i = 0; i < this.GRAPH_WIDTH; i++) {
            for (int j = 0; j < this.GRAPH_HEIGHT; j++) {
                grid.drawRectangularGrid(i, j);
                if (this.graph[i][j] == NodeType.MARKED) {
                    grid.fillRectangularGrid(i, j, NodeColor.MARKED_COLOR);
                } else if (this.graph[i][j] == NodeType.VISITED) {
                    grid.fillRectangularGrid(i, j, NodeColor.VISITED_COLOR);
                } else if (this.graph[i][j] == NodeType.IN_QUEUE) {
                    grid.fillRectangularGrid(i, j, NodeColor.IN_QUEUE_COLOR);
                } else if (this.graph[i][j] == NodeType.SOURCE) {
                    grid.fillRectangularGrid(i, j, NodeColor.SOURCE_COLOR);
                } else if (this.graph[i][j] == NodeType.DESTINATION) {
                    grid.fillRectangularGrid(i, j, NodeColor.DESTINATION_COLOR);
                }
            }
        }

        if (!this.isOneTimeDeclared) {
            this.addMouseListener(new GridMouseListener(this));
            this.isOneTimeDeclared = true;
        }
    }

    @Override
    public JFrame getFrame() {
        return this.frame;
    }

    @Override
    public int getGraphWidth() {
        return this.GRAPH_WIDTH;
    }

    @Override
    public int getGraphHeight() {
        return this.GRAPH_HEIGHT;
    }

    @Override
    public void setSourceNode(Point point) {
        this.sourceNode = point;
    }

    @Override
    public Point getSourceNode() {
        return this.sourceNode;
    }

    @Override
    public void setDestinationNode(Point destinationNode) {
        this.destinationNode = destinationNode;
    }

    @Override
    public Point getDestinationNode() {
        return this.destinationNode;
    }

    @Override
    public void setCurrentNodeStage(NodeType currentNodeStage) {
        this.currentNodeStage = currentNodeStage;
    }

    @Override
    public NodeType getCurrentNodeStage() {
        return this.currentNodeStage;
    }

    @Override
    public void setNodeType(Point point, NodeType type) {
        this.graph[(int) point.getX()][(int) point.getY()] = type;
    }

    @Override
    public NodeType getNodeType(Point point) {
        return this.graph[(int) point.getX()][(int) point.getY()];
    }

    @Override
    public NodeType[][] getGraph() {
        return this.graph;
    }
}
