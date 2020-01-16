package GUI;

import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GridMouseListener implements MouseListener {

    private MainCanvasInterface canvas;
    private RectangularGrid grid;

    public GridMouseListener(MainCanvasInterface canvas) {
        this.canvas = canvas;
        this.grid = new RectangularGrid(this.canvas.getGraphics(), this.canvas.getWidth(),
                this.canvas.getHeight(), this.canvas.getGraphWidth(), this.canvas.getGraphHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = this.grid.getRectangularGridIndexes(e.getX(), e.getY());
        if (point != null) {
            switch (this.canvas.getCurrentNodeStage()) {
                case SOURCE:
                    if (this.canvas.getNodeType(point) == NodeType.NOT_VISITED) {
                        Point oldPoint = this.canvas.getSourceNode();
                        // Update Source Node
                        this.canvas.setSourceNode(point);

                        // Delete Old Source Node
                        this.canvas.setNodeType(oldPoint, NodeType.NOT_VISITED);
                        this.grid.fillRectangularGrid((int) oldPoint.getX(), (int) oldPoint.getY(), NodeColor.NOT_VISITED_COLOR);

                        // Update New Source Node
                        this.canvas.setNodeType(point, NodeType.SOURCE);
                        this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.SOURCE_COLOR);
                    } else {
                        JOptionPane.showMessageDialog(this.canvas.getFrame(), "Cannot update this not to " +
                                "Source Node", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    this.canvas.setCurrentNodeStage(NodeType.MARKED);
                    break;

                case DESTINATION:
                    if (this.canvas.getNodeType(point) == NodeType.NOT_VISITED) {
                        Point oldPoint = this.canvas.getDestinationNode();
                        // Update Destination Node
                        this.canvas.setDestinationNode(point);

                        // Delete Old Destination Node
                        this.canvas.setNodeType(oldPoint, NodeType.NOT_VISITED);
                        this.grid.fillRectangularGrid((int) oldPoint.getX(), (int) oldPoint.getY(), NodeColor.NOT_VISITED_COLOR);

                        // Update New Destination Node
                        this.canvas.setNodeType(point, NodeType.DESTINATION);
                        this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.DESTINATION_COLOR);
                    } else {
                        JOptionPane.showMessageDialog(this.canvas.getFrame(), "Cannot update this not to " +
                                "Destination Node", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    this.canvas.setCurrentNodeStage(NodeType.MARKED);
                    break;

                case MARKED:
                    if (this.canvas.getNodeType(point) == NodeType.NOT_VISITED) {
                        this.canvas.setNodeType(point, NodeType.MARKED);
                        this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.MARKED_COLOR);
                    } else if (this.canvas.getNodeType(point) == NodeType.MARKED) {
                        this.canvas.setNodeType(point, NodeType.NOT_VISITED);
                        this.grid.fillRectangularGrid((int) point.getX(), (int) point.getY(), NodeColor.NOT_VISITED_COLOR);
                    }
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
