package GUI;

import UtilityClasses.ConstKeys;
import UtilityClasses.RectangularGrid;
import algorithms.DijkstraAlgorithm;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuItemListener implements ActionListener, ChangeListener {

    private MainCanvas canvas;
    private RectangularGrid grid;

    public MenuItemListener(MainCanvas mainCanvas) {
        this.canvas = mainCanvas;
    }

    private void initializeRectangularGrid() {
        this.grid = new RectangularGrid(this.canvas.getGraphics(), this.canvas.getWidth(),
                this.canvas.getHeight(), this.canvas.getGraphWidth(), this.canvas.getGraphHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case ConstKeys.FIND_PATH_MENU_ITEM:
                this.findPathMenuItem();
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }

    private void findPathMenuItem() {
        this.initializeRectangularGrid();
        DijkstraAlgorithm d = new DijkstraAlgorithm(this.canvas.getGraph(),
                this.canvas.getGraphWidth(), this.canvas.getGraphHeight(), this.grid, this.canvas.geSourceNode());
        Thread th = new Thread(d);
        System.out.println("START");
        th.start();
    }
}
