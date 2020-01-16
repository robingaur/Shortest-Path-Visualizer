package GUI;

import UtilityClasses.NodeType;

import javax.swing.*;
import java.awt.*;

public interface MainCanvasInterface {

    /**
     * @return the JFrame object
     */
    JFrame getFrame();

    /**
     * @return Graphics Object
     */
    Graphics getGraphics();

    /**
     * @return the Width of panel
     */
    int getWidth();

    /**
     * @return the Height of JPanel
     */
    int getHeight();

    /**
     * This method will repaint the JFrame
     */
    void repaint();

    /**
     * This method will reset the graph.
     */
    void resetCanvas();

    /**
     * @return graph
     */
    NodeType[][] getGraph();

    /**
     * @return graph width
     */
    int getGraphWidth();

    /**
     * @return graph height
     */
    int getGraphHeight();

    /**
     * This method will set the point of source/starting node of the Graph.
     *
     * @param point of source node
     */
    void setSourceNode(Point point);

    /**
     * @return point of source/starting node.
     */
    Point getSourceNode();

    /**
     * This method will set the point of destination node of the Graph.
     *
     * @param point of source node
     */
    void setDestinationNode(Point point);

    /**
     * @return point of destination node.
     */
    Point getDestinationNode();

    /**
     * This method will change the current stage of the nodes.
     *
     * @param currentNodeStage
     */
    void setCurrentNodeStage(NodeType currentNodeStage);

    /**
     * @return the current Stage of the Node
     */
    NodeType getCurrentNodeStage();

    /**
     * This method will set the NodeType of given Node('s point).
     *
     * @param point
     * @param type
     */
    void setNodeType(Point point, NodeType type);

    /**
     * @param point
     * @return NodeTypw of given Node('s point)
     */
    NodeType getNodeType(Point point);
}
