package UtilityClasses;

import java.awt.*;

public interface RectangularGridInterface {

    void drawRectangularGrid(int row, int col);

    void fillRectangularGrid(int row, int col, Color color);

    Point getRectangularGridIndexes(int row, int col);
}
