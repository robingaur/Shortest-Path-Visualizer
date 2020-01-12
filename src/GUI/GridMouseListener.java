package GUI;

import UtilityClasses.RectangularGrid;

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
        this.grid.getRectangularGridIndexes(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
