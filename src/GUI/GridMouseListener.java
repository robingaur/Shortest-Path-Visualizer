package GUI;

import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GridMouseListener implements MouseListener {

    private MainCanvas mainCanvas;
    private RectangularGrid grid;

    public GridMouseListener(MainCanvas mainCanvas) {
        this.mainCanvas = mainCanvas;
        this.grid = new RectangularGrid(this.mainCanvas.getGraphics(), this.mainCanvas.getWidth(),
                this.mainCanvas.getHeight(), this.mainCanvas.getGraphWidth(), this.mainCanvas.getGraphHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point point = this.grid.getRectangularGridIndexes(e.getX(), e.getY());
        if (point != null) {
            switch (this.mainCanvas.getCurrentNodeStage()) {
                case SOURCE:
                    this.mainCanvas.setSourceNode(point);
                    this.mainCanvas.setNodeType(point, NodeType.SOURCE);
                    this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.SOURCE_COLOR);
                    this.mainCanvas.setCurrentNodeStage(NodeType.MARKED);
                    break;

                case DESTINATION:
                    this.mainCanvas.setDestinationNode(point);
                    this.mainCanvas.setNodeType(point, NodeType.DESTINATION);
                    this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.DESTINATION_COLOR);
                    this.mainCanvas.setCurrentNodeStage(NodeType.MARKED);
                    break;

                case MARKED:
                    if (this.mainCanvas.getNodeType(point) == NodeType.NOT_VISITED) {
                        this.mainCanvas.setNodeType(point, NodeType.MARKED);
                        this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.MARKED_COLOR);
                    } else if (this.mainCanvas.getNodeType(point) == NodeType.MARKED) {
                        this.mainCanvas.setNodeType(point, NodeType.NOT_VISITED);
                        this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.NOT_VISITED_COLOR);
                    }
                    break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
