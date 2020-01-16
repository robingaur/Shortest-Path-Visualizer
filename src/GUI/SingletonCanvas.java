package GUI;

import javax.swing.*;

public class SingletonCanvas {

    private static MainCanvasInterface canvas;

    public static MainCanvasInterface getCanvas() {
        if (canvas == null) {
            canvas = new MainCanvas();
        }
        return canvas;
    }

    public static JFrame getFrame() {
        return canvas.getFrame();
    }
}
