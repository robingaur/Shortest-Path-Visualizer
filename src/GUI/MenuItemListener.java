package GUI;

import UtilityClasses.ConstKeys;
import UtilityClasses.NodeColor;
import UtilityClasses.NodeType;
import UtilityClasses.RectangularGrid;
import algorithms.AlgorithmsInterface;
import algorithms.DijkstraAlgorithm;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MenuItemListener implements ActionListener, ChangeListener, KeyListener {

    private MainCanvasInterface canvas;
    private RectangularGrid grid;
    private AlgorithmsInterface algorithms;
    private int animationDelay;

    public MenuItemListener(MainCanvasInterface mainCanvas) {
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
            case ConstKeys.START_PAUSE_MENU_ITEM:
                this.startPauseMenuItem();
                break;
            case ConstKeys.RESET_GRAPH_MENU_ITEM:
                this.resetGraphMenuItem();
                break;
            case ConstKeys.EDIT_GRAPH_MENU_ITEM:
                this.editGraphMenuItem();
                break;
            case ConstKeys.CHANGE_SOURCE_MENU_ITEM:
                this.changeSourceMenuItem();
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
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_S:
                this.findPathMenuItem();
                break;
            case KeyEvent.VK_SPACE:
                this.startPauseMenuItem();
                break;
            case KeyEvent.VK_F:
                this.finishExecutionMenuItem();
                break;
            case KeyEvent.VK_R:
                this.resetGraphMenuItem();
                break;
            case KeyEvent.VK_E:
                this.editGraphMenuItem();
                break;
        }
    }

    private void findPathMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Already finding Path.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        this.initializeRectangularGrid();
        this.algorithms = new DijkstraAlgorithm(this.canvas.getGraph(), this.grid,
                this.canvas.getSourceNode(), this.canvas.getDestinationNode());
        this.animationDelay = this.algorithms.getAnimationDelay();
        Thread thread = new Thread(this.algorithms, ConstKeys.SORTING_THREAD);
        thread.start();
    }

    private void startPauseMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                if (this.algorithms.getAnimationDelay() == Integer.MAX_VALUE) {
                    this.algorithms.setAnimationDelay(this.animationDelay);
                    thread.interrupt();
                } else {
                    this.animationDelay = this.algorithms.getAnimationDelay();
                    this.algorithms.setAnimationDelay(Integer.MAX_VALUE);
                }
            }
        }

    }

    private void finishExecutionMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                this.algorithms.setAnimationDelay(0);
                return;
            }
        }

        JOptionPane.showMessageDialog(this.canvas.getFrame(), "No Algorithm is running.", "Error!",
                JOptionPane.ERROR_MESSAGE);
    }

    private void resetGraphMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Current Execution not completed.",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        this.canvas.resetCanvas();
        this.canvas.repaint();
    }

    private void editGraphMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Current Execution not completed.",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        NodeType[][] graph = this.canvas.getGraph();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == NodeType.VISITED || graph[i][j] == NodeType.IN_QUEUE) {
                    graph[i][j] = NodeType.NOT_VISITED;
                    this.grid.fillRectangularGrid(i, j, NodeColor.NOT_VISITED_COLOR);
                }
            }
        }

        this.canvas.repaint();
    }

    private void changeSourceMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Current Execution not completed.",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        this.canvas.setCurrentNodeStage(NodeType.SOURCE);
    }
}
