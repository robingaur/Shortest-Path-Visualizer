package UtilityClasses;

import java.awt.*;

public interface RectangularGridInterface {

    /**
     * This function will draw a black color rectangle at (row, col).
     *
     * @param row
     * @param col
     */
    void drawRectangularGrid(int row, int col);

    /**
     * This function will fill color rectangle and draw a black color rectange at (row, col).
     *
     * @param row
     * @param col
     * @param color
     */
    void fillRectangularGrid(int row, int col, Color color);

    /**
     * This function will return (row, col) for a (x, y) pixel coordinate.
     *
     * @param x
     * @param y
     * @return Point object
     */
    Point getRectangularGridIndexes(int x, int y);
}
