package GUI;

import java.awt.*;

public interface MainCanvasInterface {

    int getGraphWidth();

    int getGraphHeight();

    void setSourceNode(Point point);

    Point geSourceNode();

    void setDestinationNode(Point destinationNode);

    Point getDestinationNode();
}
