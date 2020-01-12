package GUI;

import UtilityClasses.ConstKeys;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

class EventQueueThread implements Runnable {

    private MainCanvas mainCanvas;
    private JFrame frame;
    private MenuItemListener menuItemListener;

    public EventQueueThread(MainCanvas mainCanvas, JFrame frame) {
        this.mainCanvas = mainCanvas;
        this.frame = frame;
        this.menuItemListener = new MenuItemListener(mainCanvas);
    }

    @Override
    public void run() {
        try {
            this.frame = new JFrame("Shortest Path Visualizer");
            this.frame.setVisible(true);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setResizable(false);
            this.frame.setBackground(Color.WHITE);
            this.frame.add(this.mainCanvas);
            this.frame.setJMenuBar(this.setMenuBar());

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.frame.setSize(screenSize);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuMenu = new JMenu("Menu");
        JMenu editMenu = new JMenu("Edit");
        JMenu speedMenu = new JMenu("Speed");
        JMenu helpMenu = new JMenu("Help");

        {
            // MenuMenu
            JMenuItem start_pause = new JMenuItem("Start/Pause");
            start_pause.setActionCommand(ConstKeys.START_PAUSE_MENU_ITEM);
            start_pause.addActionListener(this.menuItemListener);
            menuMenu.add(start_pause);

            JMenuItem finishExecution = new JMenuItem("Finish Execution");
            finishExecution.setActionCommand(ConstKeys.FINISH_EXECUTION_MENU_ITEM);
            finishExecution.addActionListener(this.menuItemListener);
            menuMenu.add(finishExecution);

            menuBar.add(menuMenu);
        }

        {
            //Edit Menu
            JMenuItem changeSource = new JMenuItem("Change Source");
            changeSource.setActionCommand(ConstKeys.CHANGE_SOURCE_MENU_ITEM);
            changeSource.addActionListener(this.menuItemListener);
            editMenu.add(changeSource);

            // change destination
            JMenuItem changeDestination = new JMenuItem("Change Destination");
            changeDestination.setActionCommand(ConstKeys.CHANGE_DESTINATION_MENU_ITEM);
            changeDestination.addActionListener(this.menuItemListener);
            editMenu.add(changeDestination);

            menuBar.add(editMenu);
        }

        {
            // Speed Menu
            JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 99, 50);
            Hashtable<Integer, JLabel> labelNames = new Hashtable<>();
            labelNames.put(1, new JLabel("Slow"));
            labelNames.put(50, new JLabel("Normal"));
            labelNames.put(99, new JLabel("Fast"));
            speedSlider.setLabelTable(labelNames);
            speedSlider.setPaintLabels(true);
            speedSlider.setPaintTicks(true);
            speedSlider.setMajorTickSpacing(10);
            speedSlider.addChangeListener(this.menuItemListener);
            speedMenu.add(speedSlider);

            menuBar.add(speedMenu);
        }

        {
            // Help Menu
            menuBar.add(helpMenu);
        }
        return menuBar;
    }
}
