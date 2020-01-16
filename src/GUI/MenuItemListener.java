package GUI;

import UtilityClasses.ConstKeys;
import UtilityClasses.RectangularGrid;
import algorithms.DijkstraAlgorithm;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MenuItemListener implements ActionListener, ChangeListener, KeyListener {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void findPathMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Sorting is not Completed.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        this.initializeRectangularGrid();
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(this.canvas.getGraph(), this.grid, this.canvas.geSourceNode());
        Thread thread = new Thread(algorithm, ConstKeys.SORTING_THREAD);
        thread.start();
    }


}
