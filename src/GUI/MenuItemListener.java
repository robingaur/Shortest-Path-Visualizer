package GUI;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuItemListener implements ActionListener, ChangeListener {

    private MainCanvas mainCanvas;

    public MenuItemListener(MainCanvas mainCanvas) {
        this.mainCanvas = mainCanvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
