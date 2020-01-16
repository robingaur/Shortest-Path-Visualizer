package GUI;

import UtilityClasses.NodeType;

import javax.swing.*;
import java.awt.*;

public interface MainCanvasInterface {

    JFrame getFrame();

    int getGraphWidth();

    int getGraphHeight();

    void setSourceNode(Point point);

    Point geSourceNode();

    void setDestinationNode(Point destinationNode);

    Point getDestinationNode();

    void setCurrentNodeStage(NodeType currentNodeStage);

    NodeType getCurrentNodeStage();

    void setNodeType(Point point, NodeType type);

    NodeType getNodeType(Point point);

    NodeType[][] getGraph();
}
